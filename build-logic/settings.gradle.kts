@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        // https://medium.com/@ichchhamoktan07/adding-ktor-to-my-kotlin-multiplatform-project-for-web-web-assembly-or-wasm-4f6adad39b73
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include(":convention")