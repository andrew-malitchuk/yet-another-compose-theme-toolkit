import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("dev.yactt.convention.library")
    alias(libs.plugins.kotlinSerialization)

}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.navigation.compose)
            implementation(libs.kotlinx.serialization.core) // Use the latest version
        }
    }
}

