package dev.yactt.domain.usecase.source

import dev.yactt.domain.core.source.model.ThemeEntity
import dev.yactt.domain.usecase.core.monad.Optional

interface SetThemeUseCase {
    suspend operator fun invoke(theme: ThemeEntity): Optional
}