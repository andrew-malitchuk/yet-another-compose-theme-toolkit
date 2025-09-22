package dev.yactt.presentation.feature.about.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.yactt.presentation.core.navigation.core.ext.openLink
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.feature.about.source.about.AboutScreen
import dev.yactt.presentation.feature.about.source.about.mvi.AboutEffect

fun NavGraphBuilder.aboutNavigationGraph(navController: NavHostController) {
    navigation<NavigationDirection.About>(
        startDestination = AboutNavigationDirection.About,
    ) {
        composable<AboutNavigationDirection.About> {
            AboutScreen(
                isInCompactMode = false,
            ) { effect ->
                when (effect) {
                    AboutEffect.OnNavBackClickEffect ->
                        navController.safeNavigation(
                            NavigationDirection.Home,
                        )

                    AboutEffect.OnGithubClickEffect -> navController.openLink("https://github.com/andrew-malitchuk")
                }
            }
        }
    }
}
