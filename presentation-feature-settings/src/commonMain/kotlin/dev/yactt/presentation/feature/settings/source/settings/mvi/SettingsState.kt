package dev.yactt.presentation.feature.settings.source.settings.mvi

import dev.yactt.domain.core.source.model.FrameworkEntity
import dev.yactt.domain.core.source.model.LanguageEntity
import dev.yactt.domain.core.source.model.ThemeEntity
import dev.yactt.presentation.core.platform.mvi.MviState

data class SettingsState(
    val isLoading: Boolean = false,
    val language: LanguageEntity? = null,
    val theme: ThemeEntity? = null,
    val framework: FrameworkEntity? = null,
) : MviState
