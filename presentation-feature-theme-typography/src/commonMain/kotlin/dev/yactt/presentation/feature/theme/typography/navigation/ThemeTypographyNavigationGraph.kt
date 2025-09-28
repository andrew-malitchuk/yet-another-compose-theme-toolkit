package dev.yactt.presentation.feature.theme.typography.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.theme.typography.source.typography.ThemeTypographyScreen
import dev.yactt.presentation.feature.theme.typography.source.typography.mvi.ThemeTypographyEffect

fun NavGraphBuilder.themeTypographyNavigationGraph(navController: NavHostController) {
    navigation<NavigationDirection.ThemeTypography>(
        startDestination = ThemeTypographyNavigationDirection.ThemeTypography,
    ) {
        composable<ThemeTypographyNavigationDirection.ThemeTypography> {
            ThemeTypographyScreen(
                isInCompactMode = false,
            ) { effect ->
                when (effect) {
                    ThemeTypographyEffect.OnNavBackClickEffect ->
                        navController.safeNavigation(NavigationDirection.Home)
                }
            }
        }
    }
}
