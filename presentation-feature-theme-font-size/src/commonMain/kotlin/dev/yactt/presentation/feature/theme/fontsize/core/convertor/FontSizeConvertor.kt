package dev.yactt.presentation.feature.theme.fontsize.core.convertor

import dev.yactt.presentation.core.platform.core.convertor.base.BaseArtifactConvertor
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorState

class FontSizeConvertor(
    override val packageName: String,
    override val className: String,
) : BaseArtifactConvertor<SizeConfiguratorState>(packageName, className) {
    override fun generateArtifact(state: SizeConfiguratorState): String {
        val props =
            state.values.joinToString(separator = ",\n   ") { entry ->
                "val ${entry.name.value}: TextUnit"
            }

        return """
        |package $packageName.styling.core
        |
        |import androidx.compose.ui.unit.TextUnit
        |
        |data class $className(
        |   $props
        |)
        |
            """.trimMargin()
    }

    override fun generateAttribute(state: SizeConfiguratorState): String {
        val props =
            state.values.joinToString(separator = ",\n   ") { entry ->
                "${entry.name.value} = ${entry.size.value}.sp"
            }

        return """
        |package $packageName.styling.source.attribute
        |
        |import androidx.compose.ui.unit.sp
        |import $packageName.styling.core.$className
        |
        |val attribute${className.capitalize()} = $className(
        |   $props
        |)
        |
            """.trimMargin()
    }

    override fun generateProvider(): String =
        """
        |import androidx.compose.runtime.staticCompositionLocalOf
        |import $packageName.styling.core.$className
        |
        |internal val Local${className.capitalize()} =
        |    staticCompositionLocalOf<$className> {
        |         error("No implementation")
        |    }
        |
        """.trimMargin()
}
