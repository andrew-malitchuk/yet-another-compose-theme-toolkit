package dev.yactt.presentation.feature.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.onboarding.source.onboarding.OnboardingScreen
import dev.yactt.presentation.feature.onboarding.source.onboarding.mvi.OnboardingEffect

fun NavGraphBuilder.onboardingNavigationGraph(navController: NavHostController) {
    navigation<NavigationDirection.Onboarding>(
        startDestination = OnboardingNavigationDirection.Onboarding,
    ) {
        composable<OnboardingNavigationDirection.Onboarding> {
            OnboardingScreen { effect ->
                when (effect) {
                    OnboardingEffect.GoToHomeEffect ->
                        navController.safeNavigation(
                            NavigationDirection.Home,
                        )
                }
            }
        }
    }
}
