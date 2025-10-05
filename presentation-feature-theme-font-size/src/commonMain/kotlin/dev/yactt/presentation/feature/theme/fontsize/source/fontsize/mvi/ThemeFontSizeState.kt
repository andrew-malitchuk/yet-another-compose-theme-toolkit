package dev.yactt.presentation.feature.theme.fontsize.source.fontsize.mvi

import dev.yactt.presentation.core.platform.mvi.MviState
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorState

data class ThemeFontSizeState(
    val isLoading: Boolean = false,
    val content: SizeConfiguratorState = SizeConfiguratorState(),
) : MviState
