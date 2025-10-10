package dev.yactt.presentation.feature.theme.offset.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ThemeOffsetNavigationDirection {
    @Serializable
    data object ThemeOffset : ThemeOffsetNavigationDirection()
}
