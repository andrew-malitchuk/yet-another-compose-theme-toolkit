rootProject.name = "yet-another-compose-theme-toolkit"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":application-compose")
include(":common-core")
include(":data-repository")
include(":data-repository-impl")
include(":data-preference")
include(":data-preference-impl")
include(":domain-usecase")
include(":domain-usecase-impl")
include(":presentation-core-localisation")
include(":presentation-core-logger")
include(":presentation-core-logger-impl")
include(":presentation-core-model")
include(":presentation-core-navigation")
include(":presentation-core-styling")
include(":presentation-core-ui")
include(":presentation-core-platform")
include(":presentation-feature-about")
include(":presentation-feature-home")
include(":presentation-feature-host")
include(":presentation-feature-onboarding")
include(":presentation-feature-settings")
include(":presentation-feature-splash")