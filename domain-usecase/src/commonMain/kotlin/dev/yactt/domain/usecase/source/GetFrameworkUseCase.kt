package dev.yactt.domain.usecase.source

import dev.yactt.domain.core.source.model.FrameworkEntity

interface GetFrameworkUseCase {
    suspend operator fun invoke(): Result<FrameworkEntity>
}