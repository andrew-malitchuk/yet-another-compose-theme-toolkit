plugins {
    id("dev.yactt.convention.feature")
    id("dev.yactt.convention.di")
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.navigation.compose)
            implementation(libs.kotlinx.serialization.core)
            implementation(projects.domainCore)
            implementation(projects.domainUsecase)
            implementation(projects.presentationCoreNavigation)
            implementation(projects.presentationCoreUi)
            implementation(projects.presentationCoreStyling)
            implementation(projects.presentationCoreLocalisation)
            implementation(projects.presentationCorePlatform)
            implementation(projects.presentationFeatureSettings)
            implementation(projects.presentationFeatureAbout)
            implementation(projects.presentationFeatureThemeColor)
            implementation(projects.presentationFeatureThemeTypography)
            implementation(projects.presentationFeatureThemeFontSize)
            implementation(projects.presentationFeatureThemeFontFamily)
            implementation(projects.presentationFeatureThemeSize)
            implementation(projects.presentationFeatureThemeLineSize)
            implementation(projects.presentationFeatureThemeOffset)
        }
    }
}
