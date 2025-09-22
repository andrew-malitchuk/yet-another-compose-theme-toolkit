package dev.yactt.presentation.feature.about.source.about.mvi

import dev.yactt.presentation.core.platform.mvi.MviState

data class AboutState(
    val isLoading: Boolean = false,
) : MviState
