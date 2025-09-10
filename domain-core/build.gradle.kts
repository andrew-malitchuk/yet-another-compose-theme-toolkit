plugins {
    id("dev.yactt.convention.feature")
    id("dev.yactt.convention.di")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.commonCore)
            implementation(projects.domainRepository)
        }
        jvmMain.dependencies {
        }
        androidMain.dependencies {
        }
        iosMain.dependencies {
        }
    }
}
