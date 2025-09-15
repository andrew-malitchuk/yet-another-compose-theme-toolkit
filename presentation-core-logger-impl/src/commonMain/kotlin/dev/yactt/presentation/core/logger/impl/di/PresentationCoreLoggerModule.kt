package dev.yactt.presentation.core.logger.impl.di

import dev.yactt.presentation.core.logger.impl.source.LoggerImpl
import dev.yactt.presentation.core.logger.source.Logger
import org.koin.dsl.module

val presentationCoreLoggerModule = module {
    single<Logger> {
        LoggerImpl(
        )
    }
}