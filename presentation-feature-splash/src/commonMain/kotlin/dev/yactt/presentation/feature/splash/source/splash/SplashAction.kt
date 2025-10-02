package dev.yactt.presentation.feature.splash.source.splash

sealed interface SplashAction {
    data object GoToOnboardingAction : SplashAction

    data object GoToHomeAction : SplashAction
}
