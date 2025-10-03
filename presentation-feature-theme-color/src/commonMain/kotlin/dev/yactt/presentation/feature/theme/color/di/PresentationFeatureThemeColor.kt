package dev.yactt.presentation.feature.theme.color.di

import dev.yactt.presentation.feature.theme.color.source.color.ThemeColorViewModel
import org.koin.dsl.module

val presentationFeatureThemeColor =
    module {
        single<ThemeColorViewModel> { ThemeColorViewModel() }
    }
