package dev.yactt.presentation.feature.theme.fontsize.source.fontsize

import androidx.lifecycle.viewModelScope
import dev.yactt.presentation.core.platform.mvi.BaseViewModel
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorData
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorState
import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.mvi.ThemeFontSizeEffect
import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.mvi.ThemeFontSizeIntent
import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.mvi.ThemeFontSizeState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeFontSizeViewModel : BaseViewModel<ThemeFontSizeState, ThemeFontSizeIntent, ThemeFontSizeEffect>() {
    override val state: StateFlow<ThemeFontSizeState> = MutableStateFlow(ThemeFontSizeState())

    override val intent: StateFlow<ThemeFontSizeIntent?> = MutableStateFlow(null)

    override val effect: Channel<ThemeFontSizeEffect?> = Channel(Channel.CONFLATED)

    override fun onIntent(intent: ThemeFontSizeIntent) {
        when (intent) {
            ThemeFontSizeIntent.OnBackClickIntent -> onEffect(ThemeFontSizeEffect.OnNavBackClickEffect)
            ThemeFontSizeIntent.Setup ->
                updateState {
                    copy(content = SizeConfiguratorState())
                }

            ThemeFontSizeIntent.AddFontSizeIntent ->
                updateState {
                    copy(
                        content =
                            state.value.content.also {
                                it.add(SizeConfiguratorData())
                            },
                    )
                }

            is ThemeFontSizeIntent.RemoveFontSizeIntent ->
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

    override fun onEffect(effect: ThemeFontSizeEffect) {
        viewModelScope.launch {
            (this@ThemeFontSizeViewModel.effect.send(effect))
        }
    }
}
