package dev.yactt.presentation.feature.home.source.home

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.yactt.presentation.core.platform.mvi.MviOrchestrator
import dev.yactt.presentation.feature.home.source.home.mvi.HomeEffect
import dev.yactt.presentation.feature.theme.color.source.color.ThemeColorViewModel
import dev.yactt.presentation.feature.theme.color.source.color.mvi.ThemeColorState
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.ThemeFontFamilyViewModel
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi.ThemeFontFamilyState
import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.ThemeFontSizeViewModel
import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.mvi.ThemeFontSizeState
import dev.yactt.presentation.feature.theme.linesize.source.linesize.ThemeLineSizeViewModel
import dev.yactt.presentation.feature.theme.linesize.source.linesize.mvi.ThemeLineSizeState
import dev.yactt.presentation.feature.theme.offset.source.offset.ThemeOffsetViewModel
import dev.yactt.presentation.feature.theme.offset.source.offset.mvi.ThemeOffsetState
import dev.yactt.presentation.feature.theme.size.source.size.ThemeSizeViewModel
import dev.yactt.presentation.feature.theme.size.source.size.mvi.ThemeSizeState
import dev.yactt.presentation.feature.theme.typography.source.typography.ThemeTypographyViewModel
import dev.yactt.presentation.feature.theme.typography.source.typography.mvi.ThemeTypographyState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.compose.getKoin
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(onGlobalEffect: (HomeEffect) -> Unit) {
    val viewModel: HomeViewModel = koinViewModel()

    val state = viewModel.state.collectAsStateWithLifecycle()
    val intent = viewModel.intent.collectAsStateWithLifecycle(initialValue = null)
    val effect = viewModel.effect.receiveAsFlow()

    val themeColorState: StateFlow<ThemeColorState> =
        getKoin().get<ThemeColorViewModel>().state
    val themeFontSizeState: StateFlow<ThemeFontSizeState> =
        getKoin().get<ThemeFontSizeViewModel>().state
    val themeSizeState: StateFlow<ThemeSizeState> =
        getKoin().get<ThemeSizeViewModel>().state
    val themeLineSizeState: StateFlow<ThemeLineSizeState> =
        getKoin().get<ThemeLineSizeViewModel>().state
    val themeOffsetState: StateFlow<ThemeOffsetState> =
        getKoin().get<ThemeOffsetViewModel>().state
    val themeFontFamilyState: StateFlow<ThemeFontFamilyState> =
        getKoin().get<ThemeFontFamilyViewModel>().state
    val themeTypographyState: StateFlow<ThemeTypographyState> =
        getKoin().get<ThemeTypographyViewModel>().state

    viewModel.setStates(
        themeColorState = themeColorState,
        themeFontSizeState = themeFontSizeState,
        themeSizeState = themeSizeState,
        themeLineSizeState = themeLineSizeState,
        themeOffsetState = themeOffsetState,
        themeFontFamilyState = themeFontFamilyState,
        themeTypographyState = themeTypographyState,
    )

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
            HomeView(
                state = state,
                onIntent = viewModel::onIntent,
            )
        }
    }
}
