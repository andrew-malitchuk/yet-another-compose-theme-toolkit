package dev.yactt.presentation.feature.settings.source.settings.mvi

import dev.yactt.domain.core.source.model.FrameworkEntity
import dev.yactt.domain.core.source.model.LanguageEntity
import dev.yactt.domain.core.source.model.ThemeEntity
import dev.yactt.presentation.core.platform.mvi.MviIntent

sealed class SettingsIntent : MviIntent {
    data object Setup : SettingsIntent()

    data object OnNavBackIntent : SettingsIntent()

    data object OnAboutIntent : SettingsIntent()

    data class OnLanguageChangeIntent(
        val lang: LanguageEntity,
    ) : SettingsIntent()

    data class OnThemeChangeIntent(
        val theme: ThemeEntity,
    ) : SettingsIntent()

    data class OnFrameworkChangeIntent(
        val framework: FrameworkEntity,
    ) : SettingsIntent()
}
