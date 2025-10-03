package dev.yactt.presentation.feature.theme.color.source.color.mvi

import dev.yactt.presentation.core.platform.mvi.MviIntent

sealed class ThemeColorIntent : MviIntent {
    data object Setup : ThemeColorIntent()

    data object OnBackClickIntent : ThemeColorIntent()

    data object AddColorIntent : ThemeColorIntent()

    data class RemoveColorIntent(
        val index: Int,
    ) : ThemeColorIntent()
}
