package dev.yactt.presentation.feature.theme.typography.source.typography

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.yactt.presentation.core.platform.mvi.MviOrchestrator
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.ThemeFontFamilyViewModel
import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.ThemeFontSizeViewModel
import dev.yactt.presentation.feature.theme.linesize.source.linesize.ThemeLineSizeViewModel
import dev.yactt.presentation.feature.theme.typography.source.typography.mvi.ThemeTypographyEffect
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ThemeTypographyScreen(
    isInCompactMode: Boolean,
    onGlobalEffect: (ThemeTypographyEffect) -> Unit,
) {
    val viewModel: ThemeTypographyViewModel = koinViewModel()

    val themeFontSizeViewModel: ThemeFontSizeViewModel = koinViewModel()
    val themeLineSizeViewModel: ThemeLineSizeViewModel = koinViewModel()
    val themeFontFamilyViewModel: ThemeFontFamilyViewModel = koinViewModel()

    val state = viewModel.state.collectAsStateWithLifecycle()
    val intent = viewModel.intent.collectAsStateWithLifecycle(initialValue = null)
    val effect = viewModel.effect.receiveAsFlow()

    val themeFontSizeState = themeFontSizeViewModel.state.collectAsStateWithLifecycle()
    val themeLineSizeState = themeLineSizeViewModel.state.collectAsStateWithLifecycle()
    val themeFontFamilyState = themeFontFamilyViewModel.state.collectAsStateWithLifecycle()

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
            ThemeTypographyView(
                isInCompactMode = isInCompactMode,
                state = state,
                themeFontSizeState = themeFontSizeState.value,
                themeLineSizeState = themeLineSizeState.value,
                themeFontFamilyState = themeFontFamilyState.value,
                onIntent = viewModel::onIntent,
            )
        }
    }
}
