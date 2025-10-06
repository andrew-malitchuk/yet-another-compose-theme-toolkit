package dev.yactt.presentation.feature.theme.fontsize.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.ThemeFontSizeScreen
import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.mvi.ThemeFontSizeEffect

fun NavGraphBuilder.themeFontSizeNavigationGraph(navController: NavHostController) {
    navigation<NavigationDirection.ThemeFontSize>(
        startDestination = ThemeFontSizeNavigationDirection.ThemeFontSize,
    ) {
        composable<ThemeFontSizeNavigationDirection.ThemeFontSize> {
            ThemeFontSizeScreen(
                isInCompactMode = false,
            ) { effect ->
                when (effect) {
                    ThemeFontSizeEffect.OnNavBackClickEffect ->
                        navController.safeNavigation(NavigationDirection.Home)
                }
            }
        }
    }
}
