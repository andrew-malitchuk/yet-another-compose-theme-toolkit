package dev.yactt.presentation.core.navigation.core.ext

import android.content.Intent
import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavHostController

actual fun NavHostController.openLink(url: String) {
    val context = this.context ?: return
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
}

// Extension property to access context from NavController
val NavController.context
    get() = this.currentBackStackEntry?.savedStateHandle?.get<android.content.Context>("context")