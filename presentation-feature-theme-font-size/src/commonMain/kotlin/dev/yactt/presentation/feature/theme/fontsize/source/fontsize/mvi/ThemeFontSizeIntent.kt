package dev.yactt.presentation.feature.theme.fontsize.source.fontsize.mvi

import dev.yactt.presentation.core.platform.mvi.MviIntent

sealed class ThemeFontSizeIntent : MviIntent {
    data object Setup : ThemeFontSizeIntent()

    data object OnBackClickIntent : ThemeFontSizeIntent()

    data object AddFontSizeIntent : ThemeFontSizeIntent()

    data class RemoveFontSizeIntent(
        val index: Int,
    ) : ThemeFontSizeIntent()
}
