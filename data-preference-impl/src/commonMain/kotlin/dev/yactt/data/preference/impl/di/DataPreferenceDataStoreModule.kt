package dev.yactt.data.preference.impl.di

import dev.yactt.data.preference.impl.source.SettingsPreferenceSourceImpl
import dev.yactt.data.preference.source.SettingsPreferenceSource
import org.koin.dsl.module

val dataPreferenceDataStoreModule =
    module {
        single<SettingsPreferenceSource> {
            SettingsPreferenceSourceImpl(
                get(),
            )
        }
    }
