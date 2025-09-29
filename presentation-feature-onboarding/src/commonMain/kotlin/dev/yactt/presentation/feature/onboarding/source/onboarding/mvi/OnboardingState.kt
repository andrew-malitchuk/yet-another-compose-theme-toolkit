package dev.yactt.presentation.feature.onboarding.source.onboarding.mvi

import dev.yactt.domain.core.source.model.LanguageEntity
import dev.yactt.presentation.core.platform.mvi.MviState

data class OnboardingState(
    val isLoading: Boolean = false,
    val language: LanguageEntity? = null,
) : MviState
