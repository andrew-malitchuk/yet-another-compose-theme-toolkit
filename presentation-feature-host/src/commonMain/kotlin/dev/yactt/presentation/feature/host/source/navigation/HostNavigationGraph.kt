package dev.yactt.presentation.feature.host.source.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.yactt.presentation.feature.about.navigation.aboutNavigationGraph
import dev.yactt.presentation.feature.home.navigation.main.homeNavigationGraph
import dev.yactt.presentation.feature.onboarding.navigation.onboardingNavigationGraph
import dev.yactt.presentation.feature.settings.navigation.settingsNavigationGraph
import dev.yactt.presentation.feature.splash.navigation.splashNavigationGraph
import dev.yactt.presentation.feature.theme.color.navigation.themeColorNavigationGraph
import dev.yactt.presentation.feature.theme.fontfamily.navigation.themeFontFamilyNavigationGraph
import dev.yactt.presentation.feature.theme.fontsize.navigation.themeFontSizeNavigationGraph
import dev.yactt.presentation.feature.theme.linesize.navigation.themeLineSizeNavigationGraph
import dev.yactt.presentation.feature.theme.offset.navigation.themeOffsetNavigationGraph
import dev.yactt.presentation.feature.theme.size.navigation.themeSizeNavigationGraph
import dev.yactt.presentation.feature.theme.typography.navigation.themeTypographyNavigationGraph

@Composable
fun HostNavigationGraph(
    navHostController: NavHostController,
    startDestination: Any,
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        splashNavigationGraph(navHostController)
        onboardingNavigationGraph(navHostController)
        aboutNavigationGraph(navHostController)
        settingsNavigationGraph(navHostController)
        homeNavigationGraph(navHostController)
        themeColorNavigationGraph(navHostController)
        themeTypographyNavigationGraph(navHostController)
        themeFontSizeNavigationGraph(navHostController)
        themeFontFamilyNavigationGraph(navHostController)
        themeSizeNavigationGraph(navHostController)
        themeLineSizeNavigationGraph(navHostController)
        themeOffsetNavigationGraph(navHostController)
    }
}
