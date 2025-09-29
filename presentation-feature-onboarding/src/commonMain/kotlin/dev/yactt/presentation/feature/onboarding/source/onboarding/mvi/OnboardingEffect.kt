package dev.yactt.presentation.feature.onboarding.source.onboarding.mvi

import dev.yactt.presentation.core.platform.mvi.MviEffect

sealed class OnboardingEffect : MviEffect {
    data object GoToHomeEffect : OnboardingEffect()
}
