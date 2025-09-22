package dev.yactt.presentation.feature.about.source.about

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.yactt.presentation.core.platform.mvi.MviOrchestrator
import dev.yactt.presentation.feature.about.source.about.mvi.AboutEffect
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AboutScreen(
    isInCompactMode: Boolean,
    onGlobalEffect: (AboutEffect) -> Unit,
) {
    val viewModel: AboutViewModel = koinViewModel()

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
            AboutView(
                isInCompactMode = isInCompactMode,
                onIntent = viewModel::onIntent,
            )
        }
    }
}
