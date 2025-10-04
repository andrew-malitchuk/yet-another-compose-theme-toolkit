package dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi

import dev.yactt.presentation.core.platform.mvi.MviIntent

sealed class ThemeFontFamilyIntent : MviIntent {
    data object Setup : ThemeFontFamilyIntent()

    data object OnBackClickIntent : ThemeFontFamilyIntent()

    data object AddFontFamilyIntent : ThemeFontFamilyIntent()

    data class RemoveFontFamilyIntent(
        val index: Int,
    ) : ThemeFontFamilyIntent()
}
