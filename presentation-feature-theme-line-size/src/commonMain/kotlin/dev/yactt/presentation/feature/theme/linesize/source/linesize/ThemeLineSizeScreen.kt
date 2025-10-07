package dev.yactt.presentation.feature.theme.linesize.source.linesize

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.yactt.presentation.core.platform.mvi.MviOrchestrator
import dev.yactt.presentation.feature.theme.linesize.source.linesize.mvi.ThemeLineSizeEffect
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.compose.getKoin

@Composable
fun ThemeLineSizeScreen(
    isInCompactMode: Boolean,
    onGlobalEffect: (ThemeLineSizeEffect) -> Unit,
) {
    val viewModel: ThemeLineSizeViewModel = getKoin().get<ThemeLineSizeViewModel>()

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
            ThemeLineSizeView(
                isInCompactMode = isInCompactMode,
                state = state,
                onIntent = viewModel::onIntent,
            )
        }
    }
}
