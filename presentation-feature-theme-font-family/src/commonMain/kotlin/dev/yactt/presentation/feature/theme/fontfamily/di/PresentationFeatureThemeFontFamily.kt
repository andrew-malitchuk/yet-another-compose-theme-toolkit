package dev.yactt.presentation.feature.theme.fontfamily.di

import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.ThemeFontFamilyViewModel
import org.koin.dsl.module

val presentationFeatureThemeFontFamily =
    module {
        single<ThemeFontFamilyViewModel> { ThemeFontFamilyViewModel() }
    }
