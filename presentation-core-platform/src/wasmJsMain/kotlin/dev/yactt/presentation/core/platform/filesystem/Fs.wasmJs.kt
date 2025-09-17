package dev.yactt.presentation.core.platform.filesystem

import dev.yactt.presentation.core.platform.core.structure.AttributeStructure
import dev.yactt.presentation.core.platform.core.structure.AttributeStructure.Companion.generateMapStructure
import dev.yactt.presentation.core.platform.core.structure.CoreStructure
import dev.yactt.presentation.core.platform.core.structure.CoreStructure.Companion.generateMapStructure
import dev.yactt.presentation.core.platform.core.structure.ProviderStructure
import dev.yactt.presentation.core.platform.core.structure.ProviderStructure.Companion.generateMapStructure

actual class Fs actual constructor() {
    actual fun saveText(
        name: String,
        text: String,
    ) = jsSaveText(name, text)

    actual fun saveZipArchive(
        archiveName: String,
        structure: Map<String, Any>,
    ) {
        dev.yactt.presentation.core.platform.filesystem.saveZipArchive(
            archiveName = archiveName,
            structure = structure,
        )
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

@JsFun(
    """
(name, text) => {
  const blob = new Blob([text], { type: 'text/plain;charset=utf-8' });
  const url = URL.createObjectURL(blob);
  const a = document.createElement('a'); a.href = url; a.download = name; a.click();
  URL.revokeObjectURL(url);
}
""",
)
external fun jsSaveText(
    name: String,
    text: String,
): Unit
