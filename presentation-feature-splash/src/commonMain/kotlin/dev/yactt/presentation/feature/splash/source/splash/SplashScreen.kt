package dev.yactt.presentation.feature.splash.source.splash

import androidx.compose.runtime.Composable

@Composable
fun SplashScreen(onAction: (SplashAction) -> Unit) {
    SplashView(
        onAction = onAction,
    )
}
