package dev.yactt.presentation.feature.theme.linesize.source.linesize.mvi

import dev.yactt.presentation.core.platform.mvi.MviIntent

sealed class ThemeLineSizeIntent : MviIntent {
    data object Setup : ThemeLineSizeIntent()

    data object OnBackClickIntent : ThemeLineSizeIntent()

    data object AddSizeIntent : ThemeLineSizeIntent()

    data class RemoveSizeIntent(
        val index: Int,
    ) : ThemeLineSizeIntent()
}
