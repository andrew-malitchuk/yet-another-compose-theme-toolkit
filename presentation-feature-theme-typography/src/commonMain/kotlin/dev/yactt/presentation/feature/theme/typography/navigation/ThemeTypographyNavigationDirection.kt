package dev.yactt.presentation.feature.theme.typography.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ThemeTypographyNavigationDirection {
    @Serializable
    data object ThemeTypography : ThemeTypographyNavigationDirection()
}
