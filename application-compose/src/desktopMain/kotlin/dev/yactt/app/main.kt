package dev.yactt.app

import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.yactt.app.di.initKoin
import dev.yactt.presentation.core.ui.source.icon.Cube
import javax.swing.Painter

fun main() = application {
    initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "yet-another-compose-theme-toolkit",
        icon = rememberVectorPainter(Cube),
    ) {
        App()
    }
}