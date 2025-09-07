package dev.yactt.data.preference.impl.source

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.SuspendSettings
import dev.yactt.data.preference.source.SettingsPreferenceSource
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsPreferenceSourceImpl
    @OptIn(ExperimentalSettingsApi::class)
    constructor(
        val settings: SuspendSettings,
    ) : SettingsPreferenceSource {
        override val languageFlow: MutableStateFlow<String> = MutableStateFlow("")

        override val themeFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)

        override val frameworkFlow: MutableStateFlow<String> = MutableStateFlow("")

        override suspend fun getLanguage(): String? =
            settings.getString(KEY_LANGUAGE, "").ifBlank { null }?.also {
                languageFlow.emit(it)
            }

        override suspend fun setLanguage(value: String) {
            settings.putString(KEY_LANGUAGE, value)
            languageFlow.emit(value)
        }

        override suspend fun isDarkTheme(): Boolean? =
            settings.getBoolean(KEY_THEME, false).also {
                themeFlow.emit(it)
            }

        override suspend fun setDarkTheme(value: Boolean) {
            settings.putBoolean(KEY_THEME, value)
            themeFlow.emit(value)
        }

        override suspend fun isNative(): String? =
            settings.getString(KEY_FRAMEWORK, "").ifBlank { null }?.also {
                frameworkFlow.emit(it)
            }

        override suspend fun setNative(value: String) {
            settings.putString(KEY_FRAMEWORK, value)
            frameworkFlow.emit(value)
        }

        companion object {
            const val KEY_LANGUAGE = "language"
            const val KEY_THEME = "theme"
            const val KEY_FRAMEWORK = "native"
        }
    }
