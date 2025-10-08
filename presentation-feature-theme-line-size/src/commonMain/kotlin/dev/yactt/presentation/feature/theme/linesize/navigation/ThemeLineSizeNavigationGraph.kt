package dev.yactt.presentation.feature.theme.linesize.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.theme.linesize.source.linesize.ThemeLineSizeScreen
import dev.yactt.presentation.feature.theme.linesize.source.linesize.mvi.ThemeLineSizeEffect

fun NavGraphBuilder.themeLineSizeNavigationGraph(navController: NavHostController) {
    navigation<NavigationDirection.ThemeLineSize>(
        startDestination = ThemeLineSizeNavigationDirection.ThemeLineSize,
    ) {
        composable<ThemeLineSizeNavigationDirection.ThemeLineSize> {
            ThemeLineSizeScreen(
                isInCompactMode = false,
            ) { effect ->
                when (effect) {
                    ThemeLineSizeEffect.OnNavBackClickEffect ->
                        navController.safeNavigation(NavigationDirection.Home)
                }
            }
        }
    }
}
