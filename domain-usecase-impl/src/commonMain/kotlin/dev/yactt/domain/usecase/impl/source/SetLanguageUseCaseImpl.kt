package dev.yactt.domain.usecase.impl.source

import dev.yactt.domain.core.source.model.LanguageEntity
import dev.yactt.domain.repository.source.SettingsRepository
import dev.yactt.domain.usecase.core.monad.Optional
import dev.yactt.domain.usecase.impl.core.util.resultLauncher
import dev.yactt.domain.usecase.source.SetLanguageUseCase

class SetLanguageUseCaseImpl(
    private val settingsRepository: SettingsRepository,
) : SetLanguageUseCase {
    override suspend fun invoke(language: LanguageEntity): Optional =
        resultLauncher {
            settingsRepository.setLanguage(language.lang)
        }
}
