package dev.yactt.presentation.feature.theme.linesize.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ThemeLineSizeNavigationDirection {
    @Serializable
    data object ThemeLineSize : ThemeLineSizeNavigationDirection()
}
