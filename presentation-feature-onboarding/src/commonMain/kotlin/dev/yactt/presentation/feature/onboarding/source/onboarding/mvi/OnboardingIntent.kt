package dev.yactt.presentation.feature.onboarding.source.onboarding.mvi

import dev.yactt.domain.core.source.model.LanguageEntity
import dev.yactt.presentation.core.platform.mvi.MviIntent

sealed class OnboardingIntent : MviIntent {
    data object Setup : OnboardingIntent()

    data object GoToHomeIntent : OnboardingIntent()

    data class OnLanguageChangeIntent(
        val lang: LanguageEntity,
    ) : OnboardingIntent()
}
