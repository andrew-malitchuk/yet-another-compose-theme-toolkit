package dev.yactt.presentation.feature.theme.fontsize.di

import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.ThemeFontSizeViewModel
import org.koin.dsl.module

val presentationFeatureThemeFontSize =
    module {
        single<ThemeFontSizeViewModel> { ThemeFontSizeViewModel() }
    }
