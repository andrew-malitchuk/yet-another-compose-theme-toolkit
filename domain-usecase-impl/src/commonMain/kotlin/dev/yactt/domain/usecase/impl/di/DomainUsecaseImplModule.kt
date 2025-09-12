package dev.yactt.domain.usecase.impl.di

import dev.yactt.domain.usecase.impl.source.GetFrameworkUseCaseImpl
import dev.yactt.domain.usecase.impl.source.SetFrameworkUseCaseImpl
import dev.yactt.domain.usecase.impl.source.SetLanguageUseCaseImpl
import dev.yactt.domain.usecase.impl.source.SetThemeUseCaseImpl
import dev.yactt.domain.usecase.impl.source.SubscribeToFrameworkChangesUseCaseImpl
import dev.yactt.domain.usecase.impl.source.SubscribeToLanguageChangesUseCaseImpl
import dev.yactt.domain.usecase.impl.source.SubscribeToThemeChangesUseCaseImpl
import dev.yactt.domain.usecase.source.GetFrameworkUseCase
import dev.yactt.domain.usecase.source.SetFrameworkUseCase
import dev.yactt.domain.usecase.source.SetLanguageUseCase
import dev.yactt.domain.usecase.source.SetThemeUseCase
import dev.yactt.domain.usecase.source.SubscribeToFrameworkChangesUseCase
import dev.yactt.domain.usecase.source.SubscribeToLanguageChangesUseCase
import dev.yactt.domain.usecase.source.SubscribeToThemeChangesUseCase
import org.koin.dsl.module

val domainUseCaseImplModule =
    module {

        single<SubscribeToThemeChangesUseCase> {
            SubscribeToThemeChangesUseCaseImpl(
                settingsRepository = get(),
            )
        }
        single<SetThemeUseCase> {
            SetThemeUseCaseImpl(
                settingsRepository = get(),
            )
        }
        single<SetLanguageUseCase> {
            SetLanguageUseCaseImpl(
                settingsRepository = get(),
            )
        }
        single<SubscribeToLanguageChangesUseCase> {
            SubscribeToLanguageChangesUseCaseImpl(
                settingsRepository = get(),
            )
        }
        single<SetFrameworkUseCase> {
            SetFrameworkUseCaseImpl(
                settingsRepository = get(),
            )
        }
        single<GetFrameworkUseCase> {
            GetFrameworkUseCaseImpl(
                settingsRepository = get(),
            )
        }
        single<SubscribeToFrameworkChangesUseCase> {
            SubscribeToFrameworkChangesUseCaseImpl(
                settingsRepository = get(),
            )
        }
    }
