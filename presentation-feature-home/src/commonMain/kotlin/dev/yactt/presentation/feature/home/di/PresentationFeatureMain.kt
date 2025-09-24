package dev.yactt.presentation.feature.home.di

import dev.yactt.presentation.feature.home.source.home.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationFeatureMain =
    module {
        viewModelOf(::HomeViewModel)
    }
