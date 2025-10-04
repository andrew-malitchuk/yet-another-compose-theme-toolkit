package dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi

import dev.yactt.presentation.core.platform.mvi.MviState
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.font.FontFamilyConfiguratorState

data class ThemeFontFamilyState(
    val isLoading: Boolean = false,
    val content: FontFamilyConfiguratorState = FontFamilyConfiguratorState(),
) : MviState
