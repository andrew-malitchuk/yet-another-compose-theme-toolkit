package dev.yactt.presentation.feature.splash.source.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.feature.splash.core.components.widget.SplashLoading
import dev.yactt.presentation.feature.splash.source.splash.SplashAction
import kotlinx.coroutines.delay

@Composable
fun SplashView(
    modifier: Modifier = Modifier,
    onAction: (SplashAction) -> Unit,
) {
    Box(
        modifier
            .fillMaxSize()
            .background(Theme.color.neutral0),
        contentAlignment = Alignment.Center,
    ) {
        SplashLoading()
    }

    LaunchedEffect(Unit) {
        delay(2_000)
        onAction(SplashAction.GoToOnboardingAction)
    }
}
