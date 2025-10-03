package dev.yactt.presentation.feature.theme.color.source.color

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.yactt.presentation.core.platform.mvi.MviOrchestrator
import dev.yactt.presentation.feature.theme.color.source.color.mvi.ThemeColorEffect
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ThemeColorScreen(
    isInCompactMode: Boolean,
    onGlobalEffect: (ThemeColorEffect) -> Unit,
) {
    val viewModel: ThemeColorViewModel = koinViewModel()

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
            ThemeColorView(
                isInCompactMode = isInCompactMode,
                state = state,
                onIntent = viewModel::onIntent,
            )
        }
    }
}
