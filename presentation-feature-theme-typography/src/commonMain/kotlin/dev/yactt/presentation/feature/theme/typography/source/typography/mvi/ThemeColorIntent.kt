package dev.yactt.presentation.feature.theme.typography.source.typography.mvi

import dev.yactt.presentation.core.platform.mvi.MviIntent

sealed class ThemeTypographyIntent : MviIntent {
    data object Setup : ThemeTypographyIntent()

    data object OnBackClickIntent : ThemeTypographyIntent()

    data object AddTypographyIntent : ThemeTypographyIntent()

    data class RemoveTypographyIntent(
        val index: Int,
    ) : ThemeTypographyIntent()
}
