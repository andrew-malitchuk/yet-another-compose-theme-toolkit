package dev.yactt.domain.usecase.impl.source

import dev.yactt.domain.core.source.model.FrameworkEntity
import dev.yactt.domain.repository.source.SettingsRepository
import dev.yactt.domain.usecase.source.SubscribeToFrameworkChangesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SubscribeToFrameworkChangesUseCaseImpl(
    private val settingsRepository: SettingsRepository,
) : SubscribeToFrameworkChangesUseCase {
    override fun invoke(): Flow<Result<FrameworkEntity>> =
        settingsRepository.frameworkFlow.map { platform ->
            runCatching {
                FrameworkEntity.entries.firstOrNull { it.platform == platform }
                    ?: FrameworkEntity.NATIVE
            }
        }
}
