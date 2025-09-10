package dev.yactt.domain.usecase.source

import dev.yactt.domain.core.source.model.FrameworkEntity
import dev.yactt.domain.core.source.model.LanguageEntity
import dev.yactt.domain.usecase.core.monad.Optional

interface SetFrameworkUseCase {
    suspend operator fun invoke(framework: FrameworkEntity): Optional
}