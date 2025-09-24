package dev.yactt.presentation.feature.home.navigation.nested

import kotlinx.serialization.Serializable

@Serializable
sealed class HomeNestedNavigationDirection {
    @Serializable
    data object Root : HomeNestedNavigationDirection()

    @Serializable
    data object Settings : HomeNestedNavigationDirection()

    @Serializable
    data object About : HomeNestedNavigationDirection()

    @Serializable
    data object ThemeColor : HomeNestedNavigationDirection()

    @Serializable
    data object ThemeTypography : HomeNestedNavigationDirection()

    @Serializable
    data object ThemeFontSize : HomeNestedNavigationDirection()

    @Serializable
    data object ThemeFontFamily : HomeNestedNavigationDirection()

    @Serializable
    data object ThemeSize : HomeNestedNavigationDirection()

    @Serializable
    data object ThemeLineSize : HomeNestedNavigationDirection()

    @Serializable
    data object ThemeOffset : HomeNestedNavigationDirection()
}
