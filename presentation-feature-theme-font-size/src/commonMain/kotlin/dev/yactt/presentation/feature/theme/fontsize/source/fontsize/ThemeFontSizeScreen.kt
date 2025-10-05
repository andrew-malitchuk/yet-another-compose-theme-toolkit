package dev.yactt.presentation.feature.theme.fontsize.source.fontsize

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.yactt.presentation.core.platform.mvi.MviOrchestrator
import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.mvi.ThemeFontSizeEffect
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ThemeFontSizeScreen(
    isInCompactMode: Boolean,
    onGlobalEffect: (ThemeFontSizeEffect) -> Unit,
) {
    val viewModel: ThemeFontSizeViewModel = koinViewModel()

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
            ThemeFontSizeView(
                isInCompactMode = isInCompactMode,
                state = state,
                onIntent = viewModel::onIntent,
            )
        }
    }
}
