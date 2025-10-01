package dev.yactt.presentation.feature.settings.source.settings.mvi

import dev.yactt.presentation.core.platform.mvi.MviEffect

sealed class SettingsEffect : MviEffect {
    data object OnNavBackClickEffect : SettingsEffect()

    data object GoToAboutEffect : SettingsEffect()
}
