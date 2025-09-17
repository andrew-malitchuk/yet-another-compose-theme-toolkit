plugins {
    id("dev.yactt.convention.feature")
    id("dev.yactt.convention.di")
}

kotlin {

    sourceSets {
        wasmJsMain.dependencies {
            implementation(npm("jszip", "3.10.1"))
            implementation(npm("file-saver", "2.0.5"))
        }
    }
}
