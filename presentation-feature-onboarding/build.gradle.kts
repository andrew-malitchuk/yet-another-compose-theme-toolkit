plugins {
    id("dev.yactt.convention.feature")
    id("dev.yactt.convention.di")
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.navigation.compose)
            implementation(libs.kotlinx.serialization.core) // Use the latest version
            implementation(projects.presentationCoreNavigation)
            implementation(projects.presentationCoreLocalisation)
            implementation(projects.presentationCorePlatform)
            implementation(projects.presentationCoreStyling)
            implementation(projects.presentationCoreUi)
            implementation(projects.domainCore)
            implementation(projects.domainUsecase)
        }
    }
}
