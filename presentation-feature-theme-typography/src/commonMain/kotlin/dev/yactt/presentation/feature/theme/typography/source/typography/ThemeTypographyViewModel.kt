package dev.yactt.presentation.feature.theme.typography.source.typography

import androidx.lifecycle.viewModelScope
import dev.yactt.presentation.core.platform.mvi.BaseViewModel
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.typography.TypographyConfiguratorData
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.typography.TypographyConfiguratorState
import dev.yactt.presentation.feature.theme.typography.source.typography.mvi.ThemeTypographyEffect
import dev.yactt.presentation.feature.theme.typography.source.typography.mvi.ThemeTypographyIntent
import dev.yactt.presentation.feature.theme.typography.source.typography.mvi.ThemeTypographyState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeTypographyViewModel : BaseViewModel<ThemeTypographyState, ThemeTypographyIntent, ThemeTypographyEffect>() {
    override val state: StateFlow<ThemeTypographyState> = MutableStateFlow(ThemeTypographyState())

    override val intent: StateFlow<ThemeTypographyIntent?> = MutableStateFlow(null)

    override val effect: Channel<ThemeTypographyEffect?> = Channel(Channel.CONFLATED)

    override fun onIntent(intent: ThemeTypographyIntent) {
        when (intent) {
            ThemeTypographyIntent.OnBackClickIntent -> onEffect(ThemeTypographyEffect.OnNavBackClickEffect)
            ThemeTypographyIntent.AddTypographyIntent ->
                updateState {
                    copy(
                        content =
                            state.value.content.also {
                                it.add(TypographyConfiguratorData())
                            },
                    )
                }

            is ThemeTypographyIntent.RemoveTypographyIntent ->
                updateState {
                    copy(
                        content =
                            state.value.content.also {
                                it.remove(intent.index)
                            },
                    )
                }

            ThemeTypographyIntent.Setup ->
                updateState {
                    copy(
                        isLoading = true,
                        content = TypographyConfiguratorState(),
                    )
                }
        }
    }

    override fun onEffect(effect: ThemeTypographyEffect) {
        viewModelScope.launch {
            (this@ThemeTypographyViewModel.effect.send(effect))
        }
    }
}
