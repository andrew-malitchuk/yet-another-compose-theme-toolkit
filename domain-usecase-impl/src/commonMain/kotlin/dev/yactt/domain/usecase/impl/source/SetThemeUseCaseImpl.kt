package dev.yactt.domain.usecase.impl.source

import dev.yactt.domain.core.source.model.ThemeEntity
import dev.yactt.domain.repository.source.SettingsRepository
import dev.yactt.domain.usecase.core.monad.Optional
import dev.yactt.domain.usecase.impl.core.util.resultLauncher
import dev.yactt.domain.usecase.source.SetThemeUseCase

class SetThemeUseCaseImpl(
    private val settingsRepository: SettingsRepository,
) : SetThemeUseCase {
    override suspend fun invoke(theme: ThemeEntity): Optional =
        resultLauncher {
            settingsRepository.setDarkTheme(theme.isDark)
        }
}
