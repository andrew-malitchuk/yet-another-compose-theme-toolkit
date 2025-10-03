package dev.yactt.presentation.feature.theme.color.core.convertor

import dev.yactt.presentation.core.platform.core.convertor.base.BaseArtifactConvertor
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.color.ColorConfiguratorState

class ColorConvertor(
    override val packageName: String,
    override val className: String,
) : BaseArtifactConvertor<ColorConfiguratorState>(packageName, className) {
    override fun generateArtifact(state: ColorConfiguratorState): String {
        val props =
            state.values.joinToString(separator = ",\n   ") { entry ->
                "val ${entry.name.value}: Color"
            }

        return """
        |package $packageName.styling.core
        |
        |import androidx.compose.ui.graphics.Color
        |
        |data class $className(
        |   $props
        |)
        |
            """.trimMargin()
    }

    override fun generateAttribute(state: ColorConfiguratorState): String {
        val props =
            state.values.joinToString(separator = ",\n   ") { entry ->
                "${entry.name.value} = Color(0x${entry.hex.value})"
            }

        return """
        |package $packageName.styling.source.attribute
        |
        |import androidx.compose.ui.graphics.Color
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
