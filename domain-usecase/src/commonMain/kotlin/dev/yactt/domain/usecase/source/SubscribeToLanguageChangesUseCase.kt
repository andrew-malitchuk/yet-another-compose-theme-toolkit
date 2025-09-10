package dev.yactt.domain.usecase.source

import dev.yactt.domain.core.source.model.LanguageEntity
import dev.yactt.domain.core.source.model.ThemeEntity

interface SubscribeToLanguageChangesUseCase {
    operator fun invoke(): kotlinx.coroutines.flow.Flow<Result<LanguageEntity>>
}