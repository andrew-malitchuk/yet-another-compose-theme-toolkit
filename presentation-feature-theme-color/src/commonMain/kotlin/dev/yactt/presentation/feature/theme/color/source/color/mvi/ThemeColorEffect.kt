package dev.yactt.presentation.feature.theme.color.source.color.mvi

import dev.yactt.presentation.core.platform.mvi.MviEffect

sealed class ThemeColorEffect : MviEffect {
    data object OnNavBackClickEffect : ThemeColorEffect()
}
