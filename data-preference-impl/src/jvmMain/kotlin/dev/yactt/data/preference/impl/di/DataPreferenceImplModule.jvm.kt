package dev.yactt.data.preference.impl.di

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.coroutines.SuspendSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import org.koin.core.module.Module
import org.koin.dsl.module
import java.util.prefs.Preferences

actual val dataPreferenceImplModule: Module =
    module {
        single<SuspendSettings> {
            (
                PreferencesSettings
                    .Factory(Preferences.userRoot())
                    .create("myPreferences")
            ).toSuspendSettings()
        }
    }
