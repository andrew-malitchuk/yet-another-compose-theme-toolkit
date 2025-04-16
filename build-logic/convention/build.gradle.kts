import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "dev.yactt.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(libs.org.jetbrains.kotlin.multiplatform.gradle.plugin)
    implementation(libs.gradle)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.detekt.gradle.plugin)
    implementation(libs.compose.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("dev.yactt.convention.feature") {
            id = "dev.yactt.convention.feature"
            implementationClass =
                "dev.yactt.app.convention.source.plugin.FeatureConventionPlugin"
        }
        register("dev.yactt.convention.library") {
            id = "dev.yactt.convention.library"
            implementationClass =
                "dev.yactt.app.convention.source.plugin.LibraryConventionPlugin"
        }
        register("dev.yactt.convention.di") {
            id = "dev.yactt.convention.di"
            implementationClass =
                "dev.yactt.app.convention.source.plugin.DiConventionPlugin"
        }

    }
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
    }
}