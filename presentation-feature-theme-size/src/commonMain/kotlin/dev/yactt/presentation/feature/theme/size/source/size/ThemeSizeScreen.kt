package dev.yactt.presentation.feature.theme.size.source.size

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.yactt.presentation.core.platform.mvi.MviOrchestrator
import dev.yactt.presentation.feature.theme.size.source.size.mvi.ThemeSizeEffect
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ThemeSizeScreen(
    isInCompactMode: Boolean,
    onGlobalEffect: (ThemeSizeEffect) -> Unit,
) {
    val viewModel: ThemeSizeViewModel = koinViewModel()

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
            ThemeSizeView(
                isInCompactMode = isInCompactMode,
                state = state,
                onIntent = viewModel::onIntent,
            )
        }
    }
}
