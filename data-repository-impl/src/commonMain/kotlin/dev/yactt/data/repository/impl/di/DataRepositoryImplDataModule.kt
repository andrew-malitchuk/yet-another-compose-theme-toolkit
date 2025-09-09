package dev.yactt.data.repository.impl.di

import dev.yactt.data.repository.impl.source.SettingsRepositoryImpl
import dev.yactt.domain.repository.source.SettingsRepository
import org.koin.dsl.module

val dataRepositoryImplDataModule = module {
    single<SettingsRepository> {
        SettingsRepositoryImpl(
            get(),
        )
    }
}