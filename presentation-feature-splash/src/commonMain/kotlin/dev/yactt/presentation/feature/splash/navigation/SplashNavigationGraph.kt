package dev.yactt.presentation.feature.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.splash.source.splash.SplashAction
import dev.yactt.presentation.feature.splash.source.splash.SplashScreen

fun NavGraphBuilder.splashNavigationGraph(navController: NavHostController) {
    navigation<NavigationDirection.Splash>(
        startDestination = SplashNavigationDirection.Splash,
    ) {
        composable<SplashNavigationDirection.Splash> {
            SplashScreen(
                onAction = { action ->
                    when (action) {
                        SplashAction.GoToHomeAction ->
                            navController.safeNavigation(
                                NavigationDirection.Home,
                            )

                        SplashAction.GoToOnboardingAction ->
                            navController.safeNavigation(
                                NavigationDirection.Onboarding,
                            )
                    }
                },
            )
        }
    }
}
