package dev.yactt.app.convention.source.plugin

import com.android.build.gradle.LibraryExtension
import dev.yactt.app.convention.core.ext.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.compose.compose
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.gradle.kotlin.dsl.getting
import org.gradle.kotlin.dsl.provideDelegate
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

@Suppress("unused")
class FeatureConventionPlugin : Plugin<Project> {

    private val logger = Logging.getLogger(FeatureConventionPlugin::class.java)

    override fun apply(target: Project) {
        with(target) {
            val moduleName = path.replace(":", "").replace("-", ".")
            logger.lifecycle("moduleName: $path")

            with(pluginManager) {
                apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
                apply(libs.findPlugin("androidLibrary").get().get().pluginId)
                apply(libs.findPlugin("composeMultiplatform").get().get().pluginId)
                apply(libs.findPlugin("composeCompiler").get().get().pluginId)
            }

            with(libs) {
                val composeDeps = extensions.getByType<ComposeExtension>().dependencies
                extensions.getByType<KotlinMultiplatformExtension>().apply {
                    jvm()
                    androidTarget().apply {
                        compilations.all {
                            kotlinOptions {
                                jvmTarget = "21"
                            }
                        }
                    }
                    listOf(
                        iosX64(),
                        iosArm64(),
                        iosSimulatorArm64()
                    ).forEach { iosTarget ->
                        iosTarget.binaries.framework {
                            baseName = moduleName
                            isStatic = true
                            export(project("$path"))
                        }
                    }

                    sourceSets.apply {
                        androidMain.dependencies {

                        }
                        // https://slack-chats.kotlinlang.org/t/23173883/web-target-it-works-with-ios-android-desktop-but-now-my-wasm
                        commonMain.dependencies {
                            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
                            implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel:2.8.4")
                            implementation("org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose:2.8.4")
                            implementation(composeDeps.runtime)
                            implementation(composeDeps.foundation)
                            implementation(composeDeps.material)
                            implementation(composeDeps.ui)
                        }

                        jvmMain.dependencies {
                            implementation(composeDeps.desktop.currentOs)
                            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.9.0")
                        }
                    }
                }
                extensions.getByType<LibraryExtension>().apply {
                    namespace = moduleName
                    compileSdk = 34
                    defaultConfig {
                        minSdk = 24
                    }
                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_21
                        targetCompatibility = JavaVersion.VERSION_21
                    }

                }
            }
        }
    }
}
