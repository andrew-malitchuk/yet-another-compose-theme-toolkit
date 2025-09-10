package dev.yactt.domain.usecase.source

import dev.yactt.domain.core.source.model.ThemeEntity

interface SubscribeToThemeChangesUseCase {
    operator fun invoke(): kotlinx.coroutines.flow.Flow<Result<ThemeEntity>>
}