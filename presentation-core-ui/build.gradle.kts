plugins {
    id("dev.yactt.convention.feature")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.presentationCoreStyling)
            implementation(projects.presentationCoreLocalisation)
            implementation(libs.material3.windowsizeclass.multiplatform)
            implementation(libs.kotlinx.coroutines.core)
        }
    }
}
