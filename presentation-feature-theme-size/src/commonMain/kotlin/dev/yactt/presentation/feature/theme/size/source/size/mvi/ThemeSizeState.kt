package dev.yactt.presentation.feature.theme.size.source.size.mvi

import dev.yactt.presentation.core.platform.mvi.MviState
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorState

data class ThemeSizeState(
    val isLoading: Boolean = false,
    val content: SizeConfiguratorState = SizeConfiguratorState(),
) : MviState
