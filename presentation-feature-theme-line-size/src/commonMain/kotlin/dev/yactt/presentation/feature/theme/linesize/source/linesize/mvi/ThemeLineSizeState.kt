package dev.yactt.presentation.feature.theme.linesize.source.linesize.mvi

import dev.yactt.presentation.core.platform.mvi.MviState
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorState

data class ThemeLineSizeState(
    val isLoading: Boolean = false,
    val content: SizeConfiguratorState = SizeConfiguratorState(),
) : MviState
