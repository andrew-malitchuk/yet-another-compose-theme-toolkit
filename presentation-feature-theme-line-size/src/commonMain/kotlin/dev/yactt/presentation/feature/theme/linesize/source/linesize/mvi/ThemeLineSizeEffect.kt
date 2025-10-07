package dev.yactt.presentation.feature.theme.linesize.source.linesize.mvi

import dev.yactt.presentation.core.platform.mvi.MviEffect

sealed class ThemeLineSizeEffect : MviEffect {
    data object OnNavBackClickEffect : ThemeLineSizeEffect()
}
