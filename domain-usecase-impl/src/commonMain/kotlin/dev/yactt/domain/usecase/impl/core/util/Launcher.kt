package dev.yactt.domain.usecase.impl.core.util

suspend fun <T> resultLauncher(request: suspend () -> T): Result<T> =
    try {
        Result.success(request())
    } catch (e: Exception) {
        Result.failure(e)
    }
