package dev.yactt.presentation.feature.settings.source.settings

import androidx.lifecycle.viewModelScope
import dev.yactt.domain.usecase.source.SetFrameworkUseCase
import dev.yactt.domain.usecase.source.SetLanguageUseCase
import dev.yactt.domain.usecase.source.SetThemeUseCase
import dev.yactt.domain.usecase.source.SubscribeToFrameworkChangesUseCase
import dev.yactt.domain.usecase.source.SubscribeToLanguageChangesUseCase
import dev.yactt.domain.usecase.source.SubscribeToThemeChangesUseCase
import dev.yactt.presentation.core.platform.mvi.BaseViewModel
import dev.yactt.presentation.feature.settings.source.settings.mvi.SettingsEffect
import dev.yactt.presentation.feature.settings.source.settings.mvi.SettingsIntent
import dev.yactt.presentation.feature.settings.source.settings.mvi.SettingsState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val setLanguageUseCase: SetLanguageUseCase,
    private val setFrameworkUseCase: SetFrameworkUseCase,
    private val setThemeUseCase: SetThemeUseCase,
    private val getLanguageUseCase: SubscribeToLanguageChangesUseCase,
    private val getFrameworkUseCase: SubscribeToFrameworkChangesUseCase,
    private val getThemeUseCase: SubscribeToThemeChangesUseCase,
) : BaseViewModel<SettingsState, SettingsIntent, SettingsEffect>() {
    init {
        executeCoroutine {
            getLanguageUseCase().collect { result ->
                result.onSuccess { language ->
                    updateState {
                        copy(language = language)
                    }
                }
            }
        }
        executeCoroutine {
            getFrameworkUseCase().collect { result ->
                result.onSuccess { framework ->
                    updateState {
                        copy(framework = framework)
                    }
                }
            }
        }
        executeCoroutine {
            getThemeUseCase().collect { result ->
                result.onSuccess { theme ->
                    updateState {
                        copy(theme = theme)
                    }
                }
            }
        }
    }

    override val state: StateFlow<SettingsState> = MutableStateFlow(SettingsState())

    override val intent: StateFlow<SettingsIntent?> = MutableStateFlow(null)

    override val effect: Channel<SettingsEffect?> = Channel(Channel.CONFLATED)

    override fun onIntent(intent: SettingsIntent) {
        viewModelScope.launch {
            when (intent) {
                SettingsIntent.Setup ->
                    updateState {
                        copy()
                    }

                is SettingsIntent.OnLanguageChangeIntent -> {
                    updateState {
                        copy(language = intent.lang)
                    }
                    executeCoroutine {
                        setLanguageUseCase(intent.lang)
                    }
                }

                SettingsIntent.OnAboutIntent -> onEffect(SettingsEffect.GoToAboutEffect)
                SettingsIntent.OnNavBackIntent -> onEffect(SettingsEffect.OnNavBackClickEffect)
                is SettingsIntent.OnThemeChangeIntent -> {
                    updateState {
                        copy(theme = intent.theme)
                    }
                    executeCoroutine {
                        setThemeUseCase(intent.theme)
                    }
                }

                is SettingsIntent.OnFrameworkChangeIntent -> {
                    updateState {
                        copy(framework = intent.framework)
                    }
                    executeCoroutine {
                        setFrameworkUseCase(intent.framework)
                    }
                }
            }
        }
    }

    override fun onEffect(effect: SettingsEffect) {
        viewModelScope.launch {
            (this@SettingsViewModel.effect.send(effect))
        }
    }
}
