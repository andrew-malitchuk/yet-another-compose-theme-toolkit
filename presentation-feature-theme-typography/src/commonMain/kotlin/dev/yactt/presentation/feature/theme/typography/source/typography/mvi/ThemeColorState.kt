package dev.yactt.presentation.feature.theme.typography.source.typography.mvi

import dev.yactt.presentation.core.platform.mvi.MviState
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.typography.TypographyConfiguratorState

data class ThemeTypographyState(
    val isLoading: Boolean = false,
    val content: TypographyConfiguratorState = TypographyConfiguratorState(),
) : MviState
