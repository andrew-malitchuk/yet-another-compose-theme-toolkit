package dev.yactt.presentation.feature.settings.di

import dev.yactt.presentation.feature.settings.source.settings.SettingsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationFeatureSettings =
    module {
        viewModelOf(::SettingsViewModel)
    }
