package dev.yactt.domain.usecase.impl.source

import dev.yactt.domain.core.source.model.ThemeEntity
import dev.yactt.domain.repository.source.SettingsRepository
import dev.yactt.domain.usecase.source.SubscribeToThemeChangesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SubscribeToThemeChangesUseCaseImpl(
    private val settingsRepository: SettingsRepository,
) : SubscribeToThemeChangesUseCase {
    override fun invoke(): Flow<Result<ThemeEntity>> =
        settingsRepository.themeFlow.map { theme ->
            runCatching {
                ThemeEntity.entries.firstOrNull { it.isDark == theme } ?: ThemeEntity.LIGHT
            }
        }
}
