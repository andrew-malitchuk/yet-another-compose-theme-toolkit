package dev.yactt.presentation.feature.theme.fontsize.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ThemeFontSizeNavigationDirection {
    @Serializable
    data object ThemeFontSize : ThemeFontSizeNavigationDirection()
}
