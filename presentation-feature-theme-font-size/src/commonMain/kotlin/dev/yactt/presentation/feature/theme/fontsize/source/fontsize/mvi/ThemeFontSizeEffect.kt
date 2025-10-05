package dev.yactt.presentation.feature.theme.fontsize.source.fontsize.mvi

import dev.yactt.presentation.core.platform.mvi.MviEffect

sealed class ThemeFontSizeEffect : MviEffect {
    data object OnNavBackClickEffect : ThemeFontSizeEffect()
}
