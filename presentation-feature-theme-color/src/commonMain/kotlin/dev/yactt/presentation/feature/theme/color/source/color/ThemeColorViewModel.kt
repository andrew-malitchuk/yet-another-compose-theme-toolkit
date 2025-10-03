package dev.yactt.presentation.feature.theme.color.source.color

import androidx.lifecycle.viewModelScope
import dev.yactt.presentation.core.platform.mvi.BaseViewModel
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.color.ColorConfiguratorData
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.color.ColorConfiguratorState
import dev.yactt.presentation.feature.theme.color.source.color.mvi.ThemeColorEffect
import dev.yactt.presentation.feature.theme.color.source.color.mvi.ThemeColorIntent
import dev.yactt.presentation.feature.theme.color.source.color.mvi.ThemeColorState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeColorViewModel : BaseViewModel<ThemeColorState, ThemeColorIntent, ThemeColorEffect>() {
    override val state: StateFlow<ThemeColorState> = MutableStateFlow(ThemeColorState())

    override val intent: StateFlow<ThemeColorIntent?> = MutableStateFlow(null)

    override val effect: Channel<ThemeColorEffect?> = Channel(Channel.CONFLATED)

    override fun onIntent(intent: ThemeColorIntent) {
        when (intent) {
            ThemeColorIntent.OnBackClickIntent -> onEffect(ThemeColorEffect.OnNavBackClickEffect)
            ThemeColorIntent.Setup ->
                updateState {
                    copy(content = ColorConfiguratorState())
                }

            ThemeColorIntent.AddColorIntent ->
                updateState {
                    copy(
                        content =
                            state.value.content.also {
                                it.add(ColorConfiguratorData())
                            },
                    )
                }

            is ThemeColorIntent.RemoveColorIntent ->
                updateState {
                    copy(
                        content =
                            state.value.content.also {
                                it.remove(intent.index)
                            },
                    )
                }
        }
    }

    override fun onEffect(effect: ThemeColorEffect) {
        viewModelScope.launch {
            (this@ThemeColorViewModel.effect.send(effect))
        }
    }
}
