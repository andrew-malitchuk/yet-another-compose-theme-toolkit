plugins {
    id("dev.yactt.convention.feature")
    id("dev.yactt.convention.di")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.dataPreference)
            implementation(libs.multiplatform.settings)
            implementation(libs.multiplatform.settings.coroutines)
        }
    }
}
