package dev.yactt.domain.usecase.impl.source

import dev.yactt.domain.core.source.model.LanguageEntity
import dev.yactt.domain.repository.source.SettingsRepository
import dev.yactt.domain.usecase.source.SubscribeToLanguageChangesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SubscribeToLanguageChangesUseCaseImpl(
    private val settingsRepository: SettingsRepository,
) : SubscribeToLanguageChangesUseCase {
    override fun invoke(): Flow<Result<LanguageEntity>> =
        settingsRepository.languageFlow.map { lang ->
            runCatching {
                LanguageEntity.entries.firstOrNull { it.lang == lang } ?: LanguageEntity.ENGLISH
            }
        }
}
