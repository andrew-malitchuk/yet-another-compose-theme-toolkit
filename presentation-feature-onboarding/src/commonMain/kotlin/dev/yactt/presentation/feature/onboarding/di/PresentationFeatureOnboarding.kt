package dev.yactt.presentation.feature.onboarding.di

import dev.yactt.presentation.feature.onboarding.source.onboarding.OnboardingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationFeatureOnboarding =
    module {
        viewModelOf(::OnboardingViewModel)
    }
