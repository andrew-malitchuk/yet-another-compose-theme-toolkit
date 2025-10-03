package dev.yactt.presentation.feature.theme.color.source.color.mvi

import dev.yactt.presentation.core.platform.mvi.MviState
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.color.ColorConfiguratorState

data class ThemeColorState(
    val isLoading: Boolean = false,
    val content: ColorConfiguratorState = ColorConfiguratorState(),
) : MviState
