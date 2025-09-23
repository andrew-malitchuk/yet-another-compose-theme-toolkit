package dev.yactt.presentation.feature.home.source.home.mvi

import dev.yactt.domain.core.source.model.FrameworkEntity
import dev.yactt.presentation.core.platform.mvi.MviState

data class HomeState(
    val isLoading: Boolean = false,
    val framework: FrameworkEntity = FrameworkEntity.NATIVE,
) : MviState
