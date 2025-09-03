import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    id("dev.yactt.convention.di")
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "application_compose"
            isStatic = true
        }
    }

    jvm("desktop")

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        this.moduleName = "application-compose"
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            implementation(projects.presentationCoreStyling)
            implementation(projects.presentationFeatureHost)
            implementation(projects.dataPreference)
            implementation(projects.dataPreferenceImpl)
            implementation(projects.dataRepositoryImpl)
            implementation(projects.domainRepository)
            implementation(projects.dataRepositoryImpl)
            implementation(projects.domainCore)
            implementation(projects.domainUsecase)
            implementation(projects.domainUsecaseImpl)
            implementation(projects.presentationCoreUi)
            implementation(projects.presentationCoreLogger)
            implementation(projects.presentationCoreLoggerImpl)
            implementation(projects.presentationCoreLocalisation)
            implementation(projects.presentationFeatureOnboarding)
            implementation(projects.presentationFeatureHome)
            implementation(projects.presentationFeatureSettings)
            implementation(projects.presentationFeatureAbout)
            implementation(projects.presentationFeatureThemeColor)
            implementation(projects.presentationFeatureThemeTypography)
            implementation(projects.presentationFeatureThemeFontSize)
            implementation(projects.presentationFeatureThemeFontFamily)
            implementation(projects.presentationFeatureThemeSize)
            implementation(projects.presentationFeatureThemeLineSize)
            implementation(projects.presentationFeatureThemeOffset)
        }
        desktopMain.dependencies {
            implementation(libs.kotlinx.coroutines.swing)
            implementation(projects.presentationFeatureHost)
        }
    }
}

android {
    namespace = "dev.yactt.app"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "dev.yactt.app"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    dependencies {
        implementation(libs.koin.android)
        implementation(libs.koin.androidx.compose)
        api(libs.koin.core)
    }
}

compose.desktop {
    application {
        mainClass = "dev.yactt.app.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "dev.yactt.app"
            packageVersion = "1.0.0"
        }
    }
}
