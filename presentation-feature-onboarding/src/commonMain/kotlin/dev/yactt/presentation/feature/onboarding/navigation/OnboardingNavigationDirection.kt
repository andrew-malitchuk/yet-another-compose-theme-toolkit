package dev.yactt.presentation.feature.onboarding.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class OnboardingNavigationDirection {
    @Serializable
    data object Onboarding : OnboardingNavigationDirection()
}
