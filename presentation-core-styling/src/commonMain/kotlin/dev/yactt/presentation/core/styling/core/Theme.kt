package dev.yactt.presentation.core.styling.core

import androidx.compose.runtime.Composable
import dev.yactt.presentation.core.styling.source.provider.LocalThemeColor
import dev.yactt.presentation.core.styling.source.provider.LocalThemeFontSize
import dev.yactt.presentation.core.styling.source.provider.LocalThemeLineHeight
import dev.yactt.presentation.core.styling.source.provider.LocalThemeSize
import dev.yactt.presentation.core.styling.source.provider.LocalThemeSpacing
import dev.yactt.presentation.core.styling.source.provider.LocalThemeTypography

object Theme {
    val color: ThemeColor
        @Composable
        get() = LocalThemeColor.current
    val fontSize: ThemeFontSize
        @Composable
        get() = LocalThemeFontSize.current
    val size: ThemeSize
        @Composable
        get() = LocalThemeSize.current
    val lineHeight: ThemeLineHeight
        @Composable
        get() = LocalThemeLineHeight.current
    val spacing: ThemeSpacing
        @Composable
        get() = LocalThemeSpacing.current
    val typography: ThemeTypography
        @Composable
        get() = LocalThemeTypography.current
}
