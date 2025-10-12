package dev.yactt.presentation.feature.theme.size.di

import dev.yactt.presentation.feature.theme.size.source.size.ThemeSizeViewModel
import org.koin.dsl.module

val presentationFeatureThemeSize =
    module {
        single<ThemeSizeViewModel> { ThemeSizeViewModel() }
    }
