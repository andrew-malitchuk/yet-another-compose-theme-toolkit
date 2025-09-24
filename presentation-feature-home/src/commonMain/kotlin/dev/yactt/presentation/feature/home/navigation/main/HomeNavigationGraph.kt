package dev.yactt.presentation.feature.home.navigation.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.home.source.home.HomeScreen
import dev.yactt.presentation.feature.home.source.home.mvi.HomeEffect

fun NavGraphBuilder.homeNavigationGraph(navController: NavHostController) {
    navigation<NavigationDirection.Home>(
        startDestination = HomeNavigationDirection.Home,
    ) {
        composable<HomeNavigationDirection.Home> {
            HomeScreen(
                onGlobalEffect = { effect ->
                    when (effect) {
                        HomeEffect.GoToAboutEffect ->
                            navController.safeNavigation(
                                NavigationDirection.About,
                            )

                        HomeEffect.GoToSettingsEffect ->
                            navController.safeNavigation(
                                NavigationDirection.Settings,
                            )

                        HomeEffect.GoToThemeColorEffect ->
                            navController.safeNavigation(
                                NavigationDirection.ThemeColor,
                            )

                        HomeEffect.GoToThemeTypographyEffect ->
                            navController.safeNavigation(
                                NavigationDirection.ThemeTypography,
                            )

                        HomeEffect.GoToThemeFontSizeEffect ->
                            navController.safeNavigation(
                                NavigationDirection.ThemeFontSize,
                            )

                        HomeEffect.GoToThemeFontFamilyEffect ->
                            navController.safeNavigation(
                                NavigationDirection.ThemeFontFamily,
                            )

                        HomeEffect.GoToThemeSizeEffect ->
                            navController.safeNavigation(
                                NavigationDirection.ThemeSize,
                            )

                        HomeEffect.GoToThemeLineSizeEffect ->
                            navController.safeNavigation(
                                NavigationDirection.ThemeLineSize,
                            )

                        HomeEffect.GoToThemeOffsetEffect ->
                            navController.safeNavigation(
                                NavigationDirection.ThemeOffset,
                            )
                    }
                },
            )
        }
    }
}
