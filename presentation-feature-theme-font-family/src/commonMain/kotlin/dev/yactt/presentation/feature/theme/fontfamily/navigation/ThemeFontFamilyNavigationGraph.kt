package dev.yactt.presentation.feature.theme.fontfamily.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.ThemeFontFamilyScreen
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi.ThemeFontFamilyEffect

fun NavGraphBuilder.themeFontFamilyNavigationGraph(navController: NavHostController) {
    navigation<NavigationDirection.ThemeFontFamily>(
        startDestination = ThemeFontFamilyNavigationDirection.ThemeFontFamily,
    ) {
        composable<ThemeFontFamilyNavigationDirection.ThemeFontFamily> {
            ThemeFontFamilyScreen(
                isInCompactMode = false,
            ) { effect ->
                when (effect) {
                    ThemeFontFamilyEffect.OnNavBackClickEffect ->
                        navController.safeNavigation(NavigationDirection.Home)
                }
            }
        }
    }
}
