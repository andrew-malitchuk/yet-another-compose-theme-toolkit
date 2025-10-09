package dev.yactt.presentation.feature.theme.offset.source.offset.mvi

import dev.yactt.presentation.core.platform.mvi.MviState
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorState

data class ThemeOffsetState(
    val isLoading: Boolean = false,
    val content: SizeConfiguratorState = SizeConfiguratorState(),
) : MviState
