package dev.yactt.data.preference.impl.di

import android.content.Context
import com.russhwolf.settings.SharedPreferencesSettings
import com.russhwolf.settings.coroutines.SuspendSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import org.koin.core.module.Module
import org.koin.dsl.module

actual val dataPreferenceImplModule: Module =
    module {
        single<SuspendSettings> {
            val context: Context = get()
            SharedPreferencesSettings(
                context.getSharedPreferences(
                    "MyPreferences",
                    Context.MODE_PRIVATE,
                ),
            ).toSuspendSettings()
        }
    }
