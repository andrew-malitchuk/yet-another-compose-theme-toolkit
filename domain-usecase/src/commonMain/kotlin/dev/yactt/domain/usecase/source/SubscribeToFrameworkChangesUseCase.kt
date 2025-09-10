package dev.yactt.domain.usecase.source

import dev.yactt.domain.core.source.model.FrameworkEntity
import dev.yactt.domain.core.source.model.ThemeEntity

interface SubscribeToFrameworkChangesUseCase {
    operator fun invoke(): kotlinx.coroutines.flow.Flow<Result<FrameworkEntity>>
}