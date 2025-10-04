package dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi

import dev.yactt.presentation.core.platform.mvi.MviEffect

sealed class ThemeFontFamilyEffect : MviEffect {
    data object OnNavBackClickEffect : ThemeFontFamilyEffect()
}
