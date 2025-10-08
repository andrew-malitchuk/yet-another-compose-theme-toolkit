package dev.yactt.presentation.feature.theme.linesize.di

import dev.yactt.presentation.feature.theme.linesize.source.linesize.ThemeLineSizeViewModel
import org.koin.dsl.module

val presentationFeatureThemeLineSize =
    module {
        single<ThemeLineSizeViewModel> { ThemeLineSizeViewModel() }
    }
