package dev.yactt.presentation.feature.settings.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class SettingsNavigationDirection {
    @Serializable
    data object Settings : SettingsNavigationDirection()
}
