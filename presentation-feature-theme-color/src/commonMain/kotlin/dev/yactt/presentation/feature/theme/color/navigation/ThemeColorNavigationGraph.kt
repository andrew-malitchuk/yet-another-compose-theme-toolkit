package dev.yactt.presentation.feature.theme.color.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.theme.color.source.color.ThemeColorScreen
import dev.yactt.presentation.feature.theme.color.source.color.mvi.ThemeColorEffect

fun NavGraphBuilder.themeColorNavigationGraph(navController: NavHostController) {
    navigation<NavigationDirection.ThemeColor>(
        startDestination = ThemeColorNavigationDirection.ThemeColor,
    ) {
        composable<ThemeColorNavigationDirection.ThemeColor> {
            ThemeColorScreen(
                isInCompactMode = false,
            ) { effect ->
                when (effect) {
                    ThemeColorEffect.OnNavBackClickEffect ->
                        navController.safeNavigation(NavigationDirection.Home)
                }
            }
        }
    }
}
