package dev.yactt.app.di

import dev.yactt.data.preference.impl.di.dataPreferenceDataStoreModule
import dev.yactt.data.preference.impl.di.dataPreferenceImplModule
import dev.yactt.data.repository.impl.di.dataRepositoryImplDataModule
import dev.yactt.domain.repository.di.domainRepositoryModule
import dev.yactt.domain.usecase.impl.di.domainUseCaseImplModule
import dev.yactt.presentation.core.logger.impl.di.presentationCoreLoggerModule
import dev.yactt.presentation.feature.about.di.presentationFeatureAbout
import dev.yactt.presentation.feature.home.di.presentationFeatureMain
import dev.yactt.presentation.feature.onboarding.di.presentationFeatureOnboarding
import dev.yactt.presentation.feature.settings.di.presentationFeatureSettings
import dev.yactt.presentation.feature.theme.color.di.presentationFeatureThemeColor
import dev.yactt.presentation.feature.theme.fontfamily.di.presentationFeatureThemeFontFamily
import dev.yactt.presentation.feature.theme.fontsize.di.presentationFeatureThemeFontSize
import dev.yactt.presentation.feature.theme.linesize.di.presentationFeatureThemeLineSize
import dev.yactt.presentation.feature.theme.offset.di.presentationFeatureThemeOffset
import dev.yactt.presentation.feature.theme.size.di.presentationFeatureThemeSize
import dev.yactt.presentation.feature.theme.typography.di.presentationFeatureThemeTypography
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            dataPreferenceImplModule,
            dataPreferenceDataStoreModule,
            domainRepositoryModule,
            dataRepositoryImplDataModule,
            domainUseCaseImplModule,
            presentationCoreLoggerModule,
            presentationFeatureMain,
            presentationFeatureOnboarding,
            presentationFeatureSettings,
            presentationFeatureAbout,
            presentationFeatureThemeColor,
            presentationFeatureThemeTypography,
            presentationFeatureThemeFontSize,
            presentationFeatureThemeFontFamily,
            presentationFeatureThemeSize,
            presentationFeatureThemeLineSize,
            presentationFeatureThemeOffset,
        )
    }