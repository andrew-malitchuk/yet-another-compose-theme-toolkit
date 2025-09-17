package dev.yactt.presentation.core.platform.filesystem

import dev.yactt.presentation.core.platform.core.structure.AttributeStructure
import dev.yactt.presentation.core.platform.core.structure.CoreStructure
import dev.yactt.presentation.core.platform.core.structure.ProviderStructure

expect class Fs constructor() {
    fun saveText(
        name: String,
        text: String,
    )

    fun saveZipArchive(
        archiveName: String,
        structure: Map<String, Any>, // folder -> Map<String, Any>, file -> String (content)
    )

    fun generateStructure(
        basePackagePath: String,
        coreStructure: CoreStructure,
        attributeStructure: AttributeStructure,
        providerStructure: ProviderStructure,
    ): Map<String, Any>
}
