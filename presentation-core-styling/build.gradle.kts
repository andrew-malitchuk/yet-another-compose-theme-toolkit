plugins {
    id("dev.yactt.convention.feature")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.presentationCoreLocalisation)
            api(compose.components.resources)
        }
    }
}
