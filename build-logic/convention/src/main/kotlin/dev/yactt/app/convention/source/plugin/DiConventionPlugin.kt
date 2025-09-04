package dev.yactt.app.convention.source.plugin

import com.android.build.gradle.LibraryExtension
import com.android.builder.model.AndroidLibrary
import dev.yactt.app.convention.core.ext.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class DiConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            extensions.getByType<KotlinMultiplatformExtension>().apply {
                sourceSets.apply {
                    commonMain.dependencies {
                        api(libs.findLibrary("koin-core").get())
                        implementation(libs.findLibrary("koin-compose").get())
                        implementation(libs.findLibrary("koin-composeVM").get())
                    }
                    androidMain.dependencies {

                    }
                    iosMain.dependencies {

                    }
                    jvmMain.dependencies {

                    }
                }
            }
        }
    }
}
