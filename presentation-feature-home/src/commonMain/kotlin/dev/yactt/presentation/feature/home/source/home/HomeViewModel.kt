package dev.yactt.presentation.feature.home.source.home

import androidx.lifecycle.viewModelScope
import dev.yactt.domain.core.source.model.isNative
import dev.yactt.domain.usecase.source.SubscribeToFrameworkChangesUseCase
import dev.yactt.presentation.core.platform.filesystem.Fs
import dev.yactt.presentation.core.platform.mvi.BaseViewModel
import dev.yactt.presentation.feature.home.core.structure.Structure
import dev.yactt.presentation.feature.home.source.home.mvi.HomeEffect
import dev.yactt.presentation.feature.home.source.home.mvi.HomeIntent
import dev.yactt.presentation.feature.home.source.home.mvi.HomeState
import dev.yactt.presentation.feature.theme.color.source.color.mvi.ThemeColorState
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi.ThemeFontFamilyState
import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.mvi.ThemeFontSizeState
import dev.yactt.presentation.feature.theme.linesize.source.linesize.mvi.ThemeLineSizeState
import dev.yactt.presentation.feature.theme.offset.source.offset.mvi.ThemeOffsetState
import dev.yactt.presentation.feature.theme.size.source.size.mvi.ThemeSizeState
import dev.yactt.presentation.feature.theme.typography.source.typography.mvi.ThemeTypographyState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getFrameworkUseCase: SubscribeToFrameworkChangesUseCase,
) : BaseViewModel<HomeState, HomeIntent, HomeEffect>() {
    var themeColorState: StateFlow<ThemeColorState> =
        MutableStateFlow(ThemeColorState())
    var themeFontSizeState: StateFlow<ThemeFontSizeState> =
        MutableStateFlow(ThemeFontSizeState())
    var themeSizeState: StateFlow<ThemeSizeState> =
        MutableStateFlow(ThemeSizeState())
    var themeLineSizeState: StateFlow<ThemeLineSizeState> =
        MutableStateFlow(ThemeLineSizeState())
    var themeOffsetState: StateFlow<ThemeOffsetState> =
        MutableStateFlow(ThemeOffsetState())
    var themeFontFamilyState: StateFlow<ThemeFontFamilyState> =
        MutableStateFlow(ThemeFontFamilyState())
    var themeTypographyState: StateFlow<ThemeTypographyState> =
        MutableStateFlow(ThemeTypographyState())

    init {
        executeCoroutine {
            getFrameworkUseCase().collect { result ->
                result.onSuccess { framework ->
                    updateState {
                        copy(framework = framework)
                    }
                }
            }
        }
    }

    override val state: StateFlow<HomeState> = MutableStateFlow(HomeState())

    override val intent: StateFlow<HomeIntent?> = MutableStateFlow(null)

    override val effect: Channel<HomeEffect?> = Channel(Channel.CONFLATED)

    override fun onIntent(intent: HomeIntent) {
        viewModelScope.launch {
            when (intent) {
                HomeIntent.Setup ->
                    updateState {
                        copy()
                    }

                HomeIntent.GoToAboutIntent -> onEffect(HomeEffect.GoToAboutEffect)
                HomeIntent.GoToSettingsIntent -> onEffect(HomeEffect.GoToSettingsEffect)
                HomeIntent.GoToThemeColorIntent -> onEffect(HomeEffect.GoToThemeColorEffect)
                HomeIntent.GoToThemeFontFamilyIntent -> onEffect(HomeEffect.GoToThemeFontFamilyEffect)
                HomeIntent.GoToThemeFontSizeIntent -> onEffect(HomeEffect.GoToThemeFontSizeEffect)
                HomeIntent.GoToThemeLineSizeIntent -> onEffect(HomeEffect.GoToThemeLineSizeEffect)
                HomeIntent.GoToThemeOffsetIntent -> onEffect(HomeEffect.GoToThemeOffsetEffect)
                HomeIntent.GoToThemeSizeIntent -> onEffect(HomeEffect.GoToThemeSizeEffect)
                HomeIntent.GoToThemeTypographyIntent -> onEffect(HomeEffect.GoToThemeTypographyEffect)
                is HomeIntent.SaveIntent -> save(intent.packageName)
            }
        }
    }

    override fun onEffect(effect: HomeEffect) {
        viewModelScope.launch {
            (this@HomeViewModel.effect.send(effect))
        }
    }

    private fun save(packageName: String) {
        Fs().saveZipArchive(
            archiveName = "${packageName.replace(".", "_")}.zip",
            structure =
                Structure(
                    packageName,
                    isNative = state.value.framework.isNative(),
                ).getStructure(
                    color = themeColorState.value.content,
                    fontSize = themeFontSizeState.value.content,
                    lineHeight = themeLineSizeState.value.content,
                    size = themeSizeState.value.content,
                    spacing = themeOffsetState.value.content,
                    fontFamily = themeFontFamilyState.value.content,
                    typography = themeTypographyState.value.content,
                ),
        )
    }

    fun setStates(
        themeColorState: StateFlow<ThemeColorState>,
        themeFontSizeState: StateFlow<ThemeFontSizeState>,
        themeSizeState: StateFlow<ThemeSizeState>,
        themeLineSizeState: StateFlow<ThemeLineSizeState>,
        themeOffsetState: StateFlow<ThemeOffsetState>,
        themeFontFamilyState: StateFlow<ThemeFontFamilyState>,
        themeTypographyState: StateFlow<ThemeTypographyState>,
    ) {
        this.themeColorState = themeColorState
        this.themeFontSizeState = themeFontSizeState
        this.themeSizeState = themeSizeState
        this.themeLineSizeState = themeLineSizeState
        this.themeOffsetState = themeOffsetState
        this.themeFontFamilyState = themeFontFamilyState
        this.themeTypographyState = themeTypographyState
    }
}
