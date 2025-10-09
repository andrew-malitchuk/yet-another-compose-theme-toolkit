package dev.yactt.presentation.feature.theme.offset.source.offset

import androidx.lifecycle.viewModelScope
import dev.yactt.presentation.core.platform.mvi.BaseViewModel
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorData
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorState
import dev.yactt.presentation.feature.theme.offset.source.offset.mvi.ThemeOffsetEffect
import dev.yactt.presentation.feature.theme.offset.source.offset.mvi.ThemeOffsetIntent
import dev.yactt.presentation.feature.theme.offset.source.offset.mvi.ThemeOffsetState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeOffsetViewModel : BaseViewModel<ThemeOffsetState, ThemeOffsetIntent, ThemeOffsetEffect>() {
    override val state: StateFlow<ThemeOffsetState> = MutableStateFlow(ThemeOffsetState())

    override val intent: StateFlow<ThemeOffsetIntent?> = MutableStateFlow(null)

    override val effect: Channel<ThemeOffsetEffect?> = Channel(Channel.CONFLATED)

    override fun onIntent(intent: ThemeOffsetIntent) {
        when (intent) {
            ThemeOffsetIntent.OnBackClickIntent -> onEffect(ThemeOffsetEffect.OnNavBackClickEffect)
            ThemeOffsetIntent.Setup ->
                updateState {
                    copy(content = SizeConfiguratorState())
                }

            ThemeOffsetIntent.AddSizeIntent ->
                updateState {
                    copy(
                        content =
                            state.value.content.also {
                                it.add(SizeConfiguratorData())
                            },
                    )
                }
            is ThemeOffsetIntent.RemoveSizeIntent ->
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

    override fun onEffect(effect: ThemeOffsetEffect) {
        viewModelScope.launch {
            (this@ThemeOffsetViewModel.effect.send(effect))
        }
    }
}
