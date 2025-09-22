package dev.yactt.presentation.feature.about.di

import dev.yactt.presentation.feature.about.source.about.AboutViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationFeatureAbout =
    module {
        viewModelOf(::AboutViewModel)
    }
