package dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.yactt.presentation.core.platform.mvi.MviOrchestrator
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi.ThemeFontFamilyEffect
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ThemeFontFamilyScreen(
    isInCompactMode: Boolean,
    onGlobalEffect: (ThemeFontFamilyEffect) -> Unit,
) {
    val viewModel: ThemeFontFamilyViewModel = koinViewModel()

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
            ThemeFontFamilyView(
                isInCompactMode = isInCompactMode,
                state = state,
                onIntent = viewModel::onIntent,
            )
        }
    }
}
