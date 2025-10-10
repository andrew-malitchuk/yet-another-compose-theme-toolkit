package dev.yactt.presentation.feature.theme.offset.di

import dev.yactt.presentation.feature.theme.offset.source.offset.ThemeOffsetViewModel
import org.koin.dsl.module

val presentationFeatureThemeOffset =
    module {
        single<ThemeOffsetViewModel> { ThemeOffsetViewModel() }
    }
