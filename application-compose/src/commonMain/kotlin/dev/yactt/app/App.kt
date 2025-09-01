package dev.yactt.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.yactt.domain.core.source.model.LanguageEntity
import dev.yactt.domain.core.source.model.ThemeEntity
import dev.yactt.domain.repository.source.SettingsRepository
import dev.yactt.domain.usecase.source.SubscribeToLanguageChangesUseCase
import dev.yactt.domain.usecase.source.SubscribeToThemeChangesUseCase
import dev.yactt.presentation.core.styling.source.theme.AppTheme
import dev.yactt.presentation.feature.host.source.source.YacttApp
import kotlinx.coroutines.launch
import org.koin.compose.getKoin

@Composable
fun App() {

    val settingsRepository: SettingsRepository = getKoin().get()
    val subscribeToThemeChangesUseCase: SubscribeToThemeChangesUseCase = getKoin().get()
    val subscribeToLanguageChangesUseCase: SubscribeToLanguageChangesUseCase = getKoin().get()

    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        settingsRepository.getLanguage()
        settingsRepository.isNative()
        settingsRepository.isDarkTheme()
    }

    val language = subscribeToLanguageChangesUseCase().collectAsStateWithLifecycle(
        initialValue = Result.success(LanguageEntity.ENGLISH)
    )
    val themeFlow = subscribeToThemeChangesUseCase().collectAsStateWithLifecycle(
        initialValue = Result.success(ThemeEntity.DARK)
    )

    language.value
    themeFlow.value

    AppTheme(
        useDarkTheme = themeFlow.value.getOrNull()?.isDark ?: true,
        language = (language.value.getOrNull() ?: LanguageEntity.ENGLISH).lang,
    ) {
        YacttApp()
    }
}