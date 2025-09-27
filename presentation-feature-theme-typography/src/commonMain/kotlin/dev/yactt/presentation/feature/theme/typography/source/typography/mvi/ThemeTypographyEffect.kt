package dev.yactt.presentation.feature.theme.typography.source.typography.mvi

import dev.yactt.presentation.core.platform.mvi.MviEffect

sealed class ThemeTypographyEffect : MviEffect {
    data object OnNavBackClickEffect : ThemeTypographyEffect()
}
