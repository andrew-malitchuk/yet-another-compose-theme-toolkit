package dev.yactt.presentation.core.navigation.source.direction

import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationDirection {

    @Serializable
    data object Splash: NavigationDirection()

    @Serializable
    data object Onboarding : NavigationDirection()

    @Serializable
    data object Home : NavigationDirection()

    @Serializable
    data object About : NavigationDirection()

    @Serializable
    data object Settings : NavigationDirection()

    @Serializable
    data object ThemeColor: NavigationDirection()

    @Serializable
    data object ThemeTypography: NavigationDirection()

    @Serializable
    data object ThemeFontSize: NavigationDirection()

    @Serializable
    data object ThemeFontFamily: NavigationDirection()

    @Serializable
    data object ThemeSize: NavigationDirection()

    @Serializable
    data object ThemeLineSize: NavigationDirection()

    @Serializable
    data object ThemeOffset: NavigationDirection()

}
