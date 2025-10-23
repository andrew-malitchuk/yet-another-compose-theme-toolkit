package dev.yactt.presentation.feature.splash.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class SplashNavigationDirection {
    @Serializable
    data object Splash : SplashNavigationDirection()
}
