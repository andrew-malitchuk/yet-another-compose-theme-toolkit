package dev.yactt.presentation.core.logger.impl.source

import dev.yactt.presentation.core.logger.impl.core.platform.PlatformLogger
import dev.yactt.presentation.core.logger.source.Logger

class LoggerImpl : Logger {

    override fun log(message: String) {
        PlatformLogger.log(message)
    }

    override fun log(message: () -> String) {
        PlatformLogger.log(message())
    }
}