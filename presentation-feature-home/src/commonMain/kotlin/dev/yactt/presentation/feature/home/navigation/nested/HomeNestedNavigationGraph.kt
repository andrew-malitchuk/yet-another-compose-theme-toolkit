package dev.yactt.presentation.feature.home.navigation.nested

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.navigation.source.direction.NavigationDirection
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.EmptyState
import dev.yactt.presentation.feature.about.source.about.AboutScreen
import dev.yactt.presentation.feature.settings.source.settings.SettingsScreen
import dev.yactt.presentation.feature.settings.source.settings.mvi.SettingsEffect
import dev.yactt.presentation.feature.theme.color.source.color.ThemeColorScreen
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.ThemeFontFamilyScreen
import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.ThemeFontSizeScreen
import dev.yactt.presentation.feature.theme.linesize.source.linesize.ThemeLineSizeScreen
import dev.yactt.presentation.feature.theme.offset.source.offset.ThemeOffsetScreen
import dev.yactt.presentation.feature.theme.size.source.size.ThemeSizeScreen
import dev.yactt.presentation.feature.theme.typography.source.typography.ThemeTypographyScreen

@Composable
fun HomeNestedNavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onAction: (HomeNestedAction) -> Unit,
) {
    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = HomeNestedNavigationDirection.Root,
    ) {
        composable<HomeNestedNavigationDirection.Settings> {
            SettingsScreen(
                isInCompactMode = true,
                onGlobalEffect = { effect ->
                    when (effect) {
                        SettingsEffect.OnNavBackClickEffect ->
                            navController.safeNavigation(
                                NavigationDirection.Home,
                            )

                        SettingsEffect.GoToAboutEffect -> onAction(HomeNestedAction.GoToAboutAction)
                    }
                },
            )
        }
        composable<HomeNestedNavigationDirection.Root> {
            val localisation = LocalLocalisation.current
            EmptyState(
                title = localisation.general.welcomeTitle,
                description = localisation.general.welcomeDescription,
                onAction = {},
            )
        }
        composable<HomeNestedNavigationDirection.About> {
            AboutScreen(
                isInCompactMode = true,
            ) { }
        }
        composable<HomeNestedNavigationDirection.ThemeColor> {
            ThemeColorScreen(
                isInCompactMode = true,
            ) { }
        }
        composable<HomeNestedNavigationDirection.ThemeTypography> {
            ThemeTypographyScreen(
                isInCompactMode = true,
            ) { }
        }
        composable<HomeNestedNavigationDirection.ThemeFontSize> {
            ThemeFontSizeScreen(
                isInCompactMode = true,
            ) { }
        }
        composable<HomeNestedNavigationDirection.ThemeFontFamily> {
            ThemeFontFamilyScreen(
                isInCompactMode = true,
            ) { }
        }
        composable<HomeNestedNavigationDirection.ThemeSize> {
            ThemeSizeScreen(
                isInCompactMode = true,
            ) { }
        }
        composable<HomeNestedNavigationDirection.ThemeLineSize> {
            ThemeLineSizeScreen(
                isInCompactMode = true,
            ) { }
        }
        composable<HomeNestedNavigationDirection.ThemeOffset> {
            ThemeOffsetScreen(
                isInCompactMode = true,
            ) { }
        }
    }
}
