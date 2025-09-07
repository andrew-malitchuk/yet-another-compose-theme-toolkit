package dev.yactt.data.preference.impl.di

import com.russhwolf.settings.StorageSettings
import com.russhwolf.settings.coroutines.SuspendSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import org.koin.core.module.Module
import org.koin.dsl.module

actual val dataPreferenceImplModule: Module =
    module {
        single<SuspendSettings> {
            StorageSettings().toSuspendSettings()
        }
    }
