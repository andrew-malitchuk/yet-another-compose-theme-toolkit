package dev.yactt.presentation.feature.settings.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.settings.source.settings.SettingsScreen
import dev.yactt.presentation.feature.settings.source.settings.mvi.SettingsEffect

fun NavGraphBuilder.settingsNavigationGraph(navController: NavHostController) {
    navigation<NavigationDirection.Settings>(
        startDestination = SettingsNavigationDirection.Settings,
    ) {
        composable<SettingsNavigationDirection.Settings> {
            SettingsScreen(
                isInCompactMode = false,
                onGlobalEffect = { effect ->
                    when (effect) {
                        SettingsEffect.OnNavBackClickEffect ->
                            navController.safeNavigation(NavigationDirection.Home)

                        SettingsEffect.GoToAboutEffect ->
                            navController.safeNavigation(
                                NavigationDirection.About,
                            )
                    }
                },
            )
        }
    }
}
