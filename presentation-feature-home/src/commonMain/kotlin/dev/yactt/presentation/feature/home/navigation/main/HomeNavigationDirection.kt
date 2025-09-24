package dev.yactt.presentation.feature.home.navigation.main

import kotlinx.serialization.Serializable

@Serializable
sealed class HomeNavigationDirection {
    @Serializable
    data object Home : HomeNavigationDirection()
}
