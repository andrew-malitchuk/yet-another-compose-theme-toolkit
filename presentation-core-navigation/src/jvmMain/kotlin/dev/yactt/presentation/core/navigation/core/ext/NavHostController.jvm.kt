package dev.yactt.presentation.core.navigation.core.ext

import androidx.navigation.NavHostController
import java.awt.Desktop
import java.net.URI

actual fun NavHostController.openLink(url: String) {
    if (Desktop.isDesktopSupported()) {
        Desktop.getDesktop().browse(URI(url))
    }
}