package dev.yactt.presentation.core.logger.source

interface Logger {
    fun log(message: String)
    fun log(message: () -> String)
}