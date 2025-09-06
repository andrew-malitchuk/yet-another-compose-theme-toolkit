package dev.yactt.data.preference.source

interface SettingsPreferenceSource {

    val languageFlow: kotlinx.coroutines.flow.Flow<String>

    suspend fun getLanguage(): String?
    suspend fun setLanguage(value: String)

    val themeFlow: kotlinx.coroutines.flow.Flow<Boolean>

    suspend fun isDarkTheme(): Boolean?
    suspend fun setDarkTheme(value: Boolean)

    val frameworkFlow: kotlinx.coroutines.flow.Flow<String>

    suspend fun isNative(): String?
    suspend fun setNative(value: String)
}