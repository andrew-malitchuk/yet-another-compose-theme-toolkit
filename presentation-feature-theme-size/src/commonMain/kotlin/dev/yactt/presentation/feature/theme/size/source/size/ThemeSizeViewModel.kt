package dev.yactt.presentation.feature.theme.size.source.size

import androidx.lifecycle.viewModelScope
import dev.yactt.presentation.core.platform.mvi.BaseViewModel
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorData
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorState
import dev.yactt.presentation.feature.theme.size.source.size.mvi.ThemeSizeEffect
import dev.yactt.presentation.feature.theme.size.source.size.mvi.ThemeSizeIntent
import dev.yactt.presentation.feature.theme.size.source.size.mvi.ThemeSizeState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeSizeViewModel : BaseViewModel<ThemeSizeState, ThemeSizeIntent, ThemeSizeEffect>() {
    override val state: StateFlow<ThemeSizeState> = MutableStateFlow(ThemeSizeState())

    override val intent: StateFlow<ThemeSizeIntent?> = MutableStateFlow(null)

    override val effect: Channel<ThemeSizeEffect?> = Channel(Channel.CONFLATED)

    override fun onIntent(intent: ThemeSizeIntent) {
        when (intent) {
            ThemeSizeIntent.OnBackClickIntent -> onEffect(ThemeSizeEffect.OnNavBackClickEffect)
            ThemeSizeIntent.Setup ->
                updateState {
                    copy(content = SizeConfiguratorState())
                }

            ThemeSizeIntent.AddSizeIntent ->
                updateState {
                    copy(
                        content =
                            state.value.content.also {
                                it.add(SizeConfiguratorData())
                            },
                    )
                }

            is ThemeSizeIntent.RemoveSizeIntent ->
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

    override fun onEffect(effect: ThemeSizeEffect) {
        viewModelScope.launch {
            (this@ThemeSizeViewModel.effect.send(effect))
        }
    }
}
