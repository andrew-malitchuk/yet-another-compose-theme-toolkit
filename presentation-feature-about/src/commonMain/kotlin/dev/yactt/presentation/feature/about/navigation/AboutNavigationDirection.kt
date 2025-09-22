package dev.yactt.presentation.feature.about.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AboutNavigationDirection {
    @Serializable
    data object About : AboutNavigationDirection()
}
