package dev.yactt.presentation.feature.theme.size.source.size.mvi

import dev.yactt.presentation.core.platform.mvi.MviEffect

sealed class ThemeSizeEffect : MviEffect {
    data object OnNavBackClickEffect : ThemeSizeEffect()
}
