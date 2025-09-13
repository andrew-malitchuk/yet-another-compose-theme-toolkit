import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("dev.yactt.convention.library")
    id("dev.yactt.convention.di")
}

kotlin{
    sourceSets{
        commonMain.dependencies {
        }
    }
}