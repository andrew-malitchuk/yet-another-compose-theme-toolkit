package dev.yactt.presentation.feature.theme.typography.core.convertor

import dev.yactt.presentation.core.platform.core.convertor.base.BaseArtifactConvertor
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.typography.TypographyConfiguratorState

class TypographyConvertor(
    override val packageName: String,
    override val className: String,
) : BaseArtifactConvertor<TypographyConfiguratorState>(packageName, className) {
    override fun generateArtifact(state: TypographyConfiguratorState): String {
        val props =
            state.values.joinToString(separator = ",\n   ") { entry ->
                "val ${entry.name.value}: TextStyle"
            }

        return """
        |package $packageName.styling.core
        |
        |import androidx.compose.ui.text.TextStyle
        |
        |data class $className(
        |   $props
        |)
        |
            """.trimMargin()
    }

    override fun generateAttribute(state: TypographyConfiguratorState): String {
        val props =
            state.values.joinToString(separator = ",\n   ") { entry ->
                "${entry.name.value} = TextStyle(\n" +
                    "      fontSize = attributeThemeFontSize.${entry.fontSize.value},\n" +
                    "      lineHeight = attributeThemeLineHeight.${entry.lineHeight.value},\n" +
                    "      fontFamily = ${entry.fontFamily.value.capitalize()}FontFamily()\n" +
                    "   )"
            }

        return """|package $packageName.styling.source.attribute
        |
        |import androidx.compose.runtime.Composable
        |import androidx.compose.ui.text.TextStyle
        |import $packageName.styling.core.$className
        |
        |@Composable
        |fun Attribute${className.capitalize()}() = $className(
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
