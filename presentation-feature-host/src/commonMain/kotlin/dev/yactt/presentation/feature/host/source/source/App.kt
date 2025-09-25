package dev.yactt.presentation.feature.host.source.source

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.host.source.navigation.HostNavigationGraph

@Composable
fun YacttApp() {
    val navHostController = rememberNavController()
    HostNavigationGraph(
        navHostController = navHostController,
        startDestination = NavigationDirection.Splash,
    )
}
