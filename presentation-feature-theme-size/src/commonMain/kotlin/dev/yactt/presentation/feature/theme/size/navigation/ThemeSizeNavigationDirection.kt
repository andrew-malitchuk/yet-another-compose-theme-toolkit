package dev.yactt.presentation.feature.theme.size.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ThemeSizeNavigationDirection {
    @Serializable
    data object ThemeSize : ThemeSizeNavigationDirection()
}
