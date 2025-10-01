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
            implementation(projects.presentationCoreStyling)
            implementation(projects.presentationCorePlatform)
            implementation(projects.presentationCoreUi)
            implementation(projects.presentationCoreLocalisation)
            implementation(projects.domainRepository)
            implementation(projects.domainUsecase)
            implementation(projects.domainCore)
        }
    }
}
