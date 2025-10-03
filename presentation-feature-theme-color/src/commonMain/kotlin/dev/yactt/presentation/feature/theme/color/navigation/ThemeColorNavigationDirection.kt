package dev.yactt.presentation.feature.theme.color.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ThemeColorNavigationDirection {
    @Serializable
    data object ThemeColor : ThemeColorNavigationDirection()
}
