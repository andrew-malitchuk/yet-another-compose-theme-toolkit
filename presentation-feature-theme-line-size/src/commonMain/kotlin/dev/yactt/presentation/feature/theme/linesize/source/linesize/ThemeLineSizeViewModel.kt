package dev.yactt.presentation.feature.theme.linesize.source.linesize

import androidx.lifecycle.viewModelScope
import dev.yactt.presentation.core.platform.mvi.BaseViewModel
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorData
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorState
import dev.yactt.presentation.feature.theme.linesize.source.linesize.mvi.ThemeLineSizeEffect
import dev.yactt.presentation.feature.theme.linesize.source.linesize.mvi.ThemeLineSizeIntent
import dev.yactt.presentation.feature.theme.linesize.source.linesize.mvi.ThemeLineSizeState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeLineSizeViewModel : BaseViewModel<ThemeLineSizeState, ThemeLineSizeIntent, ThemeLineSizeEffect>() {
    override val state: StateFlow<ThemeLineSizeState> = MutableStateFlow(ThemeLineSizeState())

    override val intent: StateFlow<ThemeLineSizeIntent?> = MutableStateFlow(null)

    override val effect: Channel<ThemeLineSizeEffect?> = Channel(Channel.CONFLATED)

    override fun onIntent(intent: ThemeLineSizeIntent) {
        when (intent) {
            ThemeLineSizeIntent.OnBackClickIntent -> onEffect(ThemeLineSizeEffect.OnNavBackClickEffect)
            ThemeLineSizeIntent.Setup ->
                updateState {
                    copy(content = SizeConfiguratorState())
                }

            ThemeLineSizeIntent.AddSizeIntent ->
                updateState {
                    copy(
                        content =
                            state.value.content.also {
                                it.add(SizeConfiguratorData())
                            },
                    )
                }

            is ThemeLineSizeIntent.RemoveSizeIntent ->
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

    override fun onEffect(effect: ThemeLineSizeEffect) {
        viewModelScope.launch {
            (this@ThemeLineSizeViewModel.effect.send(effect))
        }
    }
}
