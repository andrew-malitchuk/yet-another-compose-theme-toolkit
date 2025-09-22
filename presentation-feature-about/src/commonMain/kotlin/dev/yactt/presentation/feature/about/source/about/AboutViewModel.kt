package dev.yactt.presentation.feature.about.source.about

import androidx.lifecycle.viewModelScope
import dev.yactt.presentation.core.platform.mvi.BaseViewModel
import dev.yactt.presentation.feature.about.source.about.mvi.AboutEffect
import dev.yactt.presentation.feature.about.source.about.mvi.AboutIntent
import dev.yactt.presentation.feature.about.source.about.mvi.AboutState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AboutViewModel : BaseViewModel<AboutState, AboutIntent, AboutEffect>() {
    override val state: StateFlow<AboutState> = MutableStateFlow(AboutState())

    override val intent: StateFlow<AboutIntent?> = MutableStateFlow(null)

    override val effect: Channel<AboutEffect?> = Channel(Channel.CONFLATED)

    override fun onIntent(intent: AboutIntent) {
        when (intent) {
            AboutIntent.OnBackClickIntent -> onEffect(AboutEffect.OnNavBackClickEffect)

            AboutIntent.OnGithubClickIntent -> onEffect(AboutEffect.OnGithubClickEffect)
        }
    }

    override fun onEffect(effect: AboutEffect) {
        viewModelScope.launch {
            (this@AboutViewModel.effect.send(effect))
        }
    }
}
