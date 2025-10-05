package dev.yactt.presentation.feature.theme.fontfamily.core.convertor

import dev.yactt.presentation.core.platform.core.convertor.base.BaseArtifactConvertor
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.font.FontFamilyConfiguratorState

class FontFamilyConvertor(
    override val packageName: String,
    override val className: String,
    val isNative: Boolean,
) : BaseArtifactConvertor<FontFamilyConfiguratorState>(packageName, className) {
    override fun generateArtifact(state: FontFamilyConfiguratorState): String {
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

    override fun generateAttribute(state: FontFamilyConfiguratorState): String {
        var fontFamily = ""

        state.values.forEach { entry ->

            val res =
                when (isNative) {
                    true -> "        R.font.${entry.name.value},\n"
                    false -> "        Res.font.${entry.name.value},\n"
                }

            val text =
                "@Composable\n" +
                    "fun ${entry.name.value.capitalize()}FontFamily() = FontFamily(\n" +
                    "    Font(\n" +
                    res +
                    "        weight = FontWeight.${entry.weight.value},\n" +
                    "        style =  FontStyle.${
                        entry.style.value.name.lowercase().capitalize()
                    }\n" +
                    "    )\n" +
                    ")"

            fontFamily += text + "\n\n"
        }

        val importResource =
            when (isNative) {
                true -> "$packageName.R"
                false -> "$packageName.styling.generated.resources.Res"
            }

        val importFont =
            when (isNative) {
                true -> "androidx.compose.ui.text.font.Font"
                false -> "org.jetbrains.compose.resources.Font"
            }

        return """|package $packageName.styling.source.attribute
        |
        |import androidx.compose.runtime.Composable
        |import androidx.compose.ui.text.font.FontFamily
        |import androidx.compose.ui.text.font.FontStyle
        |import androidx.compose.ui.text.font.FontWeight
        |import $importFont
        |import $importResource
        |
        |$fontFamily
        |
            """.trimMargin()
    }

    override fun generateProvider(): String = ""
}
