package dev.yactt.presentation.feature.home.source.home.mvi

import dev.yactt.presentation.core.platform.mvi.MviIntent

sealed class HomeIntent : MviIntent {
    data object Setup : HomeIntent()

    data object GoToAboutIntent : HomeIntent()

    data object GoToSettingsIntent : HomeIntent()

    data object GoToThemeColorIntent : HomeIntent()

    data object GoToThemeTypographyIntent : HomeIntent()

    data object GoToThemeFontSizeIntent : HomeIntent()

    data object GoToThemeSizeIntent : HomeIntent()

    data object GoToThemeLineSizeIntent : HomeIntent()

    data object GoToThemeOffsetIntent : HomeIntent()

    data object GoToThemeFontFamilyIntent : HomeIntent()

    data class SaveIntent(
        val packageName: String,
    ) : HomeIntent()
}
