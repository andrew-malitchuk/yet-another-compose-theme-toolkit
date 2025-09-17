package dev.yactt.presentation.core.platform.filesystem

import dev.yactt.presentation.core.platform.core.structure.AttributeStructure
import dev.yactt.presentation.core.platform.core.structure.AttributeStructure.Companion.generateMapStructure
import dev.yactt.presentation.core.platform.core.structure.CoreStructure
import dev.yactt.presentation.core.platform.core.structure.CoreStructure.Companion.generateMapStructure
import dev.yactt.presentation.core.platform.core.structure.ProviderStructure
import dev.yactt.presentation.core.platform.core.structure.ProviderStructure.Companion.generateMapStructure
import java.awt.GraphicsEnvironment
import java.io.BufferedOutputStream
import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import javax.swing.JFileChooser
import javax.swing.JOptionPane
import kotlin.io.path.outputStream

actual class Fs actual constructor() {
    actual fun saveText(
        name: String,
        text: String,
    ) {
        // If there's no GUI (CI/server), fallback to ~/Downloads
        if (GraphicsEnvironment.isHeadless()) {
            val fallbackDir = File(System.getProperty("user.home"), "Downloads").apply { mkdirs() }
            val target: Path =
                fallbackDir.toPath().resolve(if (name.contains('.')) name else "$name.txt")
            Files.write(
                target,
                text.toByteArray(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE,
            )
            return
        }

        val chooser =
            JFileChooser().apply {
                dialogTitle = "Save file"
                fileSelectionMode = JFileChooser.FILES_ONLY
                selectedFile = File(name) // suggested file name; user can change folder/name
            }

        val result = chooser.showSaveDialog(null)
        if (result != JFileChooser.APPROVE_OPTION) return // user canceled

        var file = chooser.selectedFile
        // Optional: ensure an extension if none given
        if (!file.name.contains('.')) file = File(file.parentFile, file.name + ".txt")

        if (file.exists()) {
            val overwrite =
                JOptionPane.showConfirmDialog(
                    null,
                    "File '${file.name}' already exists. Overwrite?",
                    "Confirm Overwrite",
                    JOptionPane.YES_NO_OPTION,
                )
            if (overwrite != JOptionPane.YES_OPTION) return
        }

        file.parentFile?.mkdirs()
        Files.write(
            file.toPath(),
            text.toByteArray(StandardCharsets.UTF_8),
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING,
            StandardOpenOption.WRITE,
        )
    }

    actual fun saveZipArchive(
        archiveName: String,
        structure: Map<String, Any>,
    ) {
        val targetFile: File =
            if (GraphicsEnvironment.isHeadless()) {
                // headless (CI/server): always ~/Downloads
                File(System.getProperty("user.home"), "Downloads/$archiveName").apply {
                    parentFile?.mkdirs()
                }
            } else {
                // interactive: let user choose a folder
                val chooser =
                    JFileChooser().apply {
                        dialogTitle = "Select folder to save $archiveName"
                        fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
                    }
                val result = chooser.showSaveDialog(null)
                if (result != JFileChooser.APPROVE_OPTION) return // cancelled

                File(chooser.selectedFile, archiveName)
            }

        if (targetFile.exists()) {
            val overwrite =
                JOptionPane.showConfirmDialog(
                    null,
                    "Archive '${targetFile.name}' already exists. Overwrite?",
                    "Confirm Overwrite",
                    JOptionPane.YES_NO_OPTION,
                )
            if (overwrite != JOptionPane.YES_OPTION) return
        }

        targetFile.parentFile?.mkdirs()

        ZipOutputStream(BufferedOutputStream(targetFile.toPath().outputStream())).use { zos ->
            addStructureToZip(zos, "", structure)
        }
    }

    private fun addStructureToZip(
        zos: ZipOutputStream,
        basePath: String,
        node: Map<String, Any>,
    ) {
        val now = System.currentTimeMillis()

        for ((name, value) in node) {
            val path = if (basePath.isEmpty()) name else "$basePath/$name"

            when (value) {
                is String -> {
                    val bytes = value.toByteArray(Charsets.UTF_8)
                    val entry = ZipEntry(path).apply { time = now }
                    zos.putNextEntry(entry)
                    zos.write(bytes)
                    zos.closeEntry()
                }

                is Map<*, *> -> {
                    val dirPath = if (path.endsWith("/")) path else "$path/"
                    val entry = ZipEntry(dirPath).apply { time = now }
                    zos.putNextEntry(entry)
                    zos.closeEntry()
                    @Suppress("UNCHECKED_CAST")
                    addStructureToZip(zos, dirPath.removeSuffix("/"), value as Map<String, Any>)
                }

                else -> error("Unsupported node '$path': ${value?.let { it::class }}")
            }
        }
    }

    actual fun generateStructure(
        basePackagePath: String,
        coreStructure: CoreStructure,
        attributeStructure: AttributeStructure,
        providerStructure: ProviderStructure,
    ): Map<String, Any> {
        val stylingStructure: Map<String, Any> =
            mapOf(
                "styling" to
                    mapOf(
                        "core" to coreStructure.generateMapStructure(),
                        "source" to
                            mapOf(
                                "attribute" to attributeStructure.generateMapStructure(),
                                "provider" to providerStructure.generateMapStructure(),
                            ),
                    ),
            )

        return basePackagePath.toNestedMapWithLast(stylingStructure)
    }

    fun String.toNestedMapWithLast(last: Map<String, Any>): Map<String, Any> {
        val parts = split(".")

        fun build(index: Int): Map<String, Any> =
            if (index == parts.lastIndex) {
                mapOf(parts[index] to last)
            } else {
                mapOf(parts[index] to build(index + 1))
            }

        return build(0)
    }
}
