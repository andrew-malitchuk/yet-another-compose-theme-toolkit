package dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily

import androidx.lifecycle.viewModelScope
import dev.yactt.presentation.core.platform.mvi.BaseViewModel
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.font.FontFamilyConfiguratorData
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.font.FontFamilyConfiguratorState
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi.ThemeFontFamilyEffect
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi.ThemeFontFamilyIntent
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi.ThemeFontFamilyState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeFontFamilyViewModel : BaseViewModel<ThemeFontFamilyState, ThemeFontFamilyIntent, ThemeFontFamilyEffect>() {
    override val state: StateFlow<ThemeFontFamilyState> = MutableStateFlow(ThemeFontFamilyState())

    override val intent: StateFlow<ThemeFontFamilyIntent?> = MutableStateFlow(null)

    override val effect: Channel<ThemeFontFamilyEffect?> = Channel(Channel.CONFLATED)

    override fun onIntent(intent: ThemeFontFamilyIntent) {
        when (intent) {
            ThemeFontFamilyIntent.OnBackClickIntent -> onEffect(ThemeFontFamilyEffect.OnNavBackClickEffect)
            ThemeFontFamilyIntent.Setup ->
                updateState {
                    copy(content = FontFamilyConfiguratorState())
                }

            ThemeFontFamilyIntent.AddFontFamilyIntent ->
                updateState {
                    copy(
                        content =
                            state.value.content.also {
                                it.add(FontFamilyConfiguratorData())
                            },
                    )
                }

            is ThemeFontFamilyIntent.RemoveFontFamilyIntent ->
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

    override fun onEffect(effect: ThemeFontFamilyEffect) {
        viewModelScope.launch {
            (this@ThemeFontFamilyViewModel.effect.send(effect))
        }
    }
}
