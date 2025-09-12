package dev.yactt.domain.usecase.impl.source

import dev.yactt.domain.core.source.model.FrameworkEntity
import dev.yactt.domain.repository.source.SettingsRepository
import dev.yactt.domain.usecase.impl.core.util.resultLauncher
import dev.yactt.domain.usecase.source.GetFrameworkUseCase
import kotlinx.coroutines.flow.firstOrNull

class GetFrameworkUseCaseImpl(
    private val settingsRepository: SettingsRepository,
) : GetFrameworkUseCase {
    override suspend fun invoke(): Result<FrameworkEntity> =
        resultLauncher {
            FrameworkEntity.entries.firstOrNull {
                it.platform == settingsRepository.frameworkFlow.firstOrNull()
            } ?: FrameworkEntity.NATIVE
        }
}
