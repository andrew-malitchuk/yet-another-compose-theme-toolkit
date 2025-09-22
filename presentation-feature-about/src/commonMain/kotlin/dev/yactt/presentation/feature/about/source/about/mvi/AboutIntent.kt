package dev.yactt.presentation.feature.about.source.about.mvi

import dev.yactt.presentation.core.platform.mvi.MviIntent

sealed class AboutIntent : MviIntent {
    data object OnBackClickIntent : AboutIntent()

    data object OnGithubClickIntent : AboutIntent()
}
