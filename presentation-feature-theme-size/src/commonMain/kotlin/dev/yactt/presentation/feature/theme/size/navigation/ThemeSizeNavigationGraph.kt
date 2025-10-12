package dev.yactt.presentation.feature.theme.size.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.theme.size.source.size.ThemeSizeScreen
import dev.yactt.presentation.feature.theme.size.source.size.mvi.ThemeSizeEffect

fun NavGraphBuilder.themeSizeNavigationGraph(navController: NavHostController) {
    navigation<NavigationDirection.ThemeSize>(
        startDestination = ThemeSizeNavigationDirection.ThemeSize,
    ) {
        composable<ThemeSizeNavigationDirection.ThemeSize> {
            ThemeSizeScreen(
                isInCompactMode = false,
            ) { effect ->
                when (effect) {
                    ThemeSizeEffect.OnNavBackClickEffect ->
                        navController.safeNavigation(NavigationDirection.Home)
                }
            }
        }
    }
}
