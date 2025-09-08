package dev.yactt.domain.repository.source

interface SettingsRepository {
    val languageFlow: kotlinx.coroutines.flow.Flow<String>
    val themeFlow: kotlinx.coroutines.flow.Flow<Boolean>
    val frameworkFlow: kotlinx.coroutines.flow.Flow<String>

    suspend fun getLanguage(): String?

    suspend fun setLanguage(value: String)

    suspend fun isDarkTheme(): Boolean?

    suspend fun setDarkTheme(value: Boolean)

    suspend fun isNative(): String?

    suspend fun setNative(value: String)
}
