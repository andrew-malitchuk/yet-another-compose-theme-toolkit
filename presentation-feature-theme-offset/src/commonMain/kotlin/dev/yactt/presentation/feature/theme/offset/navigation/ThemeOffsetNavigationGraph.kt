package dev.yactt.presentation.feature.theme.offset.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.theme.offset.source.offset.ThemeOffsetScreen
import dev.yactt.presentation.feature.theme.offset.source.offset.mvi.ThemeOffsetEffect

fun NavGraphBuilder.themeOffsetNavigationGraph(navController: NavHostController) {
    navigation<NavigationDirection.ThemeOffset>(
        startDestination = ThemeOffsetNavigationDirection.ThemeOffset,
    ) {
        composable<ThemeOffsetNavigationDirection.ThemeOffset> {
            ThemeOffsetScreen(
                isInCompactMode = false,
            ) { effect ->
                when (effect) {
                    ThemeOffsetEffect.OnNavBackClickEffect ->
                        navController.safeNavigation(NavigationDirection.Home)
                }
            }
        }
    }
}
