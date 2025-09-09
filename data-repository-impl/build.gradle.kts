plugins {
    id("dev.yactt.convention.library")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.commonCore)
            implementation(projects.dataPreference)
            implementation(projects.domainRepository)
        }
    }
}