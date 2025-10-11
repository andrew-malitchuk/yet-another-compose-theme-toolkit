package dev.yactt.presentation.feature.theme.size.source.size.mvi

import dev.yactt.presentation.core.platform.mvi.MviIntent

sealed class ThemeSizeIntent : MviIntent {
    data object Setup : ThemeSizeIntent()

    data object OnBackClickIntent : ThemeSizeIntent()

    data object AddSizeIntent : ThemeSizeIntent()

    data class RemoveSizeIntent(
        val index: Int,
    ) : ThemeSizeIntent()
}
