package dev.yactt.presentation.feature.onboarding.source.onboarding

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.yactt.presentation.core.platform.mvi.MviOrchestrator
import dev.yactt.presentation.core.ui.core.util.window.WindowSizeHelper.Companion.isInCompactMode
import dev.yactt.presentation.feature.onboarding.source.onboarding.mvi.OnboardingEffect
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun OnboardingScreen(onGlobalEffect: (OnboardingEffect) -> Unit) {
    val viewModel: OnboardingViewModel = koinViewModel()

    val state = viewModel.state.collectAsStateWithLifecycle()
    val intent = viewModel.intent.collectAsStateWithLifecycle(initialValue = null)
    val effect = viewModel.effect.receiveAsFlow()

    MviOrchestrator(
        state = state.value,
        intent = intent.value,
        effect = effect,
    ) {
        onEffect = { effect ->
            effect?.let {
                onGlobalEffect(it)
            }
        }
        render { state ->
            OnboardingView(
                state = state,
                isInCompactMode = isInCompactMode(),
                onIntent = viewModel::onIntent,
            )
        }
    }
}
