package dev.yactt.presentation.feature.theme.fontfamily.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ThemeFontFamilyNavigationDirection {
    @Serializable
    data object ThemeFontFamily : ThemeFontFamilyNavigationDirection()
}
