package dev.yactt.presentation.feature.home.source.home.mvi

import dev.yactt.presentation.core.platform.mvi.MviEffect

sealed class HomeEffect : MviEffect {
    data object GoToAboutEffect : HomeEffect()

    data object GoToSettingsEffect : HomeEffect()

    data object GoToThemeColorEffect : HomeEffect()

    data object GoToThemeTypographyEffect : HomeEffect()

    data object GoToThemeFontSizeEffect : HomeEffect()

    data object GoToThemeSizeEffect : HomeEffect()

    data object GoToThemeLineSizeEffect : HomeEffect()

    data object GoToThemeOffsetEffect : HomeEffect()

    data object GoToThemeFontFamilyEffect : HomeEffect()
}
