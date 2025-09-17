package dev.yactt.presentation.core.platform.core.convertor

import dev.yactt.presentation.core.platform.core.convertor.base.BaseArtifactConvertor

class ThemeConfiguratorConvertor(
    override val packageName: String,
    override val className: String,
) : BaseArtifactConvertor<Any?>(packageName, className) {
    override fun generateArtifact(state: Any?): String =
        """
        |package $packageName.styling.core
        |
        |import androidx.compose.runtime.Composable
        |import LocalThemeColor
        |import LocalThemeSize
        |import LocalThemeSpacing
        |import LocalThemeFontSize
        |import LocalThemeLineHeight
        |import LocalThemeTypography
        |
        |object Theme {
        |   val color: ThemeColor
        |       @Composable
        |       get() = LocalThemeColor.current
        |   val size: ThemeSize
        |        @Composable
        |        get() = LocalThemeSize.current
        |   val spacing: ThemeSpacing
        |        @Composable
        |       get() = LocalThemeSpacing.current
        |   val fontSize: ThemeFontSize
        |        @Composable
        |       get() = LocalThemeFontSize.current
        |   val lineHeight: ThemeLineHeight
        |        @Composable
        |        get() = LocalThemeLineHeight.current
        |   val typography: ThemeTypography
        |        @Composable
        |       get() = LocalThemeTypography.current
        |}
        |
        """.trimMargin()

    override fun generateAttribute(state: Any?): String = throw NotImplementedError()

    override fun generateProvider(): String =
        """
        |package $packageName.styling.source.provider
        |
        |import androidx.compose.runtime.Composable
        |import androidx.compose.runtime.CompositionLocalProvider
        |import $packageName.styling.source.attribute.AttributeThemeTypography
        |import $packageName.styling.source.attribute.attributeThemeFontSize
        |import $packageName.styling.source.attribute.attributeThemeLineHeight
        |import $packageName.styling.source.attribute.attributeThemeSize
        |import $packageName.styling.source.attribute.attributeThemeSpacing
        |import $packageName.styling.source.attribute.attributeThemeColor
        |import LocalThemeColor
        |import LocalThemeFontSize
        |import LocalThemeLineHeight
        |import LocalThemeSize
        |import LocalThemeSpacing
        |import LocalThemeTypography
        |
        |@Composable
        |fun AppTheme(
        |    content: @Composable () -> Unit,
        |) {
        |    CompositionLocalProvider(
        |        LocalThemeColor provides attributeThemeColor,
        |        LocalThemeSize provides attributeThemeSize,
        |        LocalThemeSpacing provides attributeThemeSpacing,
        |        LocalThemeFontSize provides attributeThemeFontSize,
        |        LocalThemeLineHeight provides attributeThemeLineHeight,
        |        LocalThemeTypography provides AttributeThemeTypography(),
        |        content = content,
        |    )
        |}
        |
        """.trimMargin()
}
