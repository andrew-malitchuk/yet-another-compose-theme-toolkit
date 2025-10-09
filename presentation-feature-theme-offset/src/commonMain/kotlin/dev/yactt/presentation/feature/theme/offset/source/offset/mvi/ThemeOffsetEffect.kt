package dev.yactt.presentation.feature.theme.offset.source.offset.mvi

import dev.yactt.presentation.core.platform.mvi.MviEffect

sealed class ThemeOffsetEffect : MviEffect {
    data object OnNavBackClickEffect : ThemeOffsetEffect()
}
