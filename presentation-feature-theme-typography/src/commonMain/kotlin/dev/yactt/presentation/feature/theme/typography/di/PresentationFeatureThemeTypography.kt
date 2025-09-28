package dev.yactt.presentation.feature.theme.typography.di

import dev.yactt.presentation.feature.theme.typography.source.typography.ThemeTypographyViewModel
import org.koin.dsl.module

val presentationFeatureThemeTypography =
    module {
        single<ThemeTypographyViewModel> { ThemeTypographyViewModel() }
    }
