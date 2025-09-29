package dev.yactt.presentation.feature.onboarding.source.onboarding

import androidx.lifecycle.viewModelScope
import dev.yactt.domain.usecase.source.SetLanguageUseCase
import dev.yactt.domain.usecase.source.SubscribeToLanguageChangesUseCase
import dev.yactt.presentation.core.platform.mvi.BaseViewModel
import dev.yactt.presentation.feature.onboarding.source.onboarding.mvi.OnboardingEffect
import dev.yactt.presentation.feature.onboarding.source.onboarding.mvi.OnboardingIntent
import dev.yactt.presentation.feature.onboarding.source.onboarding.mvi.OnboardingState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val setLanguageUseCase: SetLanguageUseCase,
    private val getLanguageUseCase: SubscribeToLanguageChangesUseCase,
) : BaseViewModel<OnboardingState, OnboardingIntent, OnboardingEffect>() {
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
    }

    override val state: StateFlow<OnboardingState> = MutableStateFlow(OnboardingState())

    override val intent: StateFlow<OnboardingIntent?> = MutableStateFlow(null)

    override val effect: Channel<OnboardingEffect?> = Channel(Channel.CONFLATED)

    override fun onIntent(intent: OnboardingIntent) {
        viewModelScope.launch {
            when (intent) {
                OnboardingIntent.Setup ->
                    updateState {
                        copy()
                    }

                OnboardingIntent.GoToHomeIntent -> onEffect(OnboardingEffect.GoToHomeEffect)
                is OnboardingIntent.OnLanguageChangeIntent -> {
                    updateState {
                        copy(language = intent.lang)
                    }
                    executeCoroutine {
                        setLanguageUseCase(intent.lang)
                    }
                }
            }
        }
    }

    override fun onEffect(effect: OnboardingEffect) {
        viewModelScope.launch {
            (this@OnboardingViewModel.effect.send(effect))
        }
    }
}
