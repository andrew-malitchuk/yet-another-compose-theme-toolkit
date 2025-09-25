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
            implementation(projects.dataPreference)
            implementation(projects.presentationCoreLogger)
            implementation(projects.presentationCoreNavigation)
            implementation(projects.presentationFeatureSplash)
            implementation(projects.presentationFeatureOnboarding)
            implementation(projects.presentationFeatureAbout)
            implementation(projects.presentationFeatureSettings)
            implementation(projects.presentationFeatureHome)
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
