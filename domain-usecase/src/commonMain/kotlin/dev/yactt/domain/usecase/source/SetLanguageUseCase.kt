package dev.yactt.domain.usecase.source

import dev.yactt.domain.core.source.model.LanguageEntity
import dev.yactt.domain.core.source.model.ThemeEntity
import dev.yactt.domain.usecase.core.monad.Optional

interface SetLanguageUseCase {
    suspend operator fun invoke(language: LanguageEntity): Optional
}