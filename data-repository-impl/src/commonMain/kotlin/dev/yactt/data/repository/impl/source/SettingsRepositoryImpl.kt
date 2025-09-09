package dev.yactt.data.repository.impl.source

import dev.yactt.data.preference.source.SettingsPreferenceSource
import dev.yactt.domain.repository.source.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.stateIn

class SettingsRepositoryImpl(
    private val settingsPreferenceSource: SettingsPreferenceSource,
) : SettingsRepository {

    override val languageFlow: Flow<String> = settingsPreferenceSource.languageFlow.stateIn(
        scope = kotlinx.coroutines.GlobalScope,
        started = kotlinx.coroutines.flow.SharingStarted.Eagerly,
        initialValue = "",
    )
    override val themeFlow: Flow<Boolean> = settingsPreferenceSource.themeFlow.stateIn(
        scope = kotlinx.coroutines.GlobalScope,
        started = kotlinx.coroutines.flow.SharingStarted.Eagerly,
        initialValue = false,
    )
    override val frameworkFlow: Flow<String> = settingsPreferenceSource.frameworkFlow.stateIn(
        scope = kotlinx.coroutines.GlobalScope,
        started = kotlinx.coroutines.flow.SharingStarted.Eagerly,
        initialValue = "",
    )

    override suspend fun getLanguage(): String? {
        return settingsPreferenceSource.getLanguage()
    }

    override suspend fun setLanguage(value: String) {
        settingsPreferenceSource.setLanguage(value)
    }

    override suspend fun isDarkTheme(): Boolean? {
        return settingsPreferenceSource.isDarkTheme()
    }

    override suspend fun setDarkTheme(value: Boolean) {
        return settingsPreferenceSource.setDarkTheme(value)
    }

    override suspend fun isNative(): String? {
        return settingsPreferenceSource.isNative()
    }

    override suspend fun setNative(value: String) {
        return settingsPreferenceSource.setNative(value)
    }
}