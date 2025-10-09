package dev.yactt.presentation.feature.theme.offset.source.offset.mvi

import dev.yactt.presentation.core.platform.mvi.MviIntent

sealed class ThemeOffsetIntent : MviIntent {
    data object Setup : ThemeOffsetIntent()

    data object OnBackClickIntent : ThemeOffsetIntent()

    data object AddSizeIntent : ThemeOffsetIntent()

    data class RemoveSizeIntent(
        val index: Int,
    ) : ThemeOffsetIntent()
}
