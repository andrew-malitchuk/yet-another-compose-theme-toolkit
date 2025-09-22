package dev.yactt.presentation.feature.about.source.about.mvi

import dev.yactt.presentation.core.platform.mvi.MviEffect

sealed class AboutEffect : MviEffect {
    data object OnNavBackClickEffect : AboutEffect()

    data object OnGithubClickEffect : AboutEffect()
}
