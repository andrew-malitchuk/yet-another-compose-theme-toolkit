package dev.yactt.domain.usecase.impl.source

import dev.yactt.domain.core.source.model.FrameworkEntity
import dev.yactt.domain.repository.source.SettingsRepository
import dev.yactt.domain.usecase.core.monad.Optional
import dev.yactt.domain.usecase.impl.core.util.resultLauncher
import dev.yactt.domain.usecase.source.SetFrameworkUseCase

class SetFrameworkUseCaseImpl(
    private val settingsRepository: SettingsRepository,
) : SetFrameworkUseCase {
    override suspend fun invoke(framework: FrameworkEntity): Optional =
        resultLauncher {
            settingsRepository.setNative(framework.platform)
        }
}
