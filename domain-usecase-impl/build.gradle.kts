plugins {
    id("dev.yactt.convention.feature")
    id("dev.yactt.convention.di")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.commonCore)
            implementation(projects.domainCore)
            implementation(projects.domainRepository)
            implementation(projects.domainUsecase)
        }
    }
}
