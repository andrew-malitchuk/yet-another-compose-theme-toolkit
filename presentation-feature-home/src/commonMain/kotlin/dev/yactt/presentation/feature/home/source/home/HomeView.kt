package dev.yactt.presentation.feature.home.source.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dev.yactt.presentation.core.navigation.core.ext.safeNavigation
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.core.util.window.WindowSizeHelper
import dev.yactt.presentation.core.ui.core.util.window.WindowSizeHelper.Companion.inInCompactMode
import dev.yactt.presentation.core.ui.source.layout.AdaptiveContainer
import dev.yactt.presentation.feature.home.navigation.nested.HomeNestedAction
import dev.yactt.presentation.feature.home.navigation.nested.HomeNestedNavigationDirection
import dev.yactt.presentation.feature.home.navigation.nested.HomeNestedNavigationGraph
import dev.yactt.presentation.feature.home.source.home.mvi.HomeIntent
import dev.yactt.presentation.feature.home.source.home.mvi.HomeState
import dev.yactt.presentation.feature.home.source.list.ListAction
import dev.yactt.presentation.feature.home.source.list.ListScreen

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    state: HomeState,
    onIntent: (HomeIntent) -> Unit,
) {
    val navHostController = rememberNavController()
    val isInCompactMode = WindowSizeHelper.isInCompactMode()

    AdaptiveContainer(
        modifier =
            modifier
                .background(Theme.color.neutral0)
                .statusBarsPadding(),
        compactContent = { modifier ->
            ListScreen(
                modifier = modifier,
                isInCompactMode = false,
                onAction = { action ->
                    when (action) {
                        ListAction.GoToAboutAction -> onIntent(HomeIntent.GoToAboutIntent)
                        ListAction.GoToSettingsAction ->
                            inInCompactMode(
                                isInCompactMode,
                                {
                                    onIntent(HomeIntent.GoToSettingsIntent)
                                },
                                {
                                    navHostController.safeNavigation(HomeNestedNavigationDirection.Settings)
                                },
                            )

                        ListAction.GoToThemeColorAction ->
                            inInCompactMode(
                                isInCompactMode,
                                {
                                    onIntent(HomeIntent.GoToThemeColorIntent)
                                },
                                {
                                    navHostController.safeNavigation(HomeNestedNavigationDirection.ThemeColor)
                                },
                            )

                        ListAction.GoToThemeTypographyAction ->
                            inInCompactMode(
                                isInCompactMode,
                                {
                                    onIntent(HomeIntent.GoToThemeTypographyIntent)
                                },
                                {
                                    navHostController.safeNavigation(HomeNestedNavigationDirection.ThemeTypography)
                                },
                            )

                        ListAction.GoToThemeFontSize ->
                            inInCompactMode(
                                isInCompactMode,
                                {
                                    onIntent(HomeIntent.GoToThemeFontSizeIntent)
                                },
                                {
                                    navHostController.safeNavigation(HomeNestedNavigationDirection.ThemeFontSize)
                                },
                            )

                        ListAction.GoToThemeSize ->
                            inInCompactMode(
                                isInCompactMode,
                                {
                                    onIntent(HomeIntent.GoToThemeSizeIntent)
                                },
                                {
                                    navHostController.safeNavigation(HomeNestedNavigationDirection.ThemeSize)
                                },
                            )

                        ListAction.GoToThemeLineSize ->
                            inInCompactMode(
                                isInCompactMode,
                                {
                                    onIntent(HomeIntent.GoToThemeLineSizeIntent)
                                },
                                {
                                    navHostController.safeNavigation(HomeNestedNavigationDirection.ThemeLineSize)
                                },
                            )

                        ListAction.GoToThemeOffset ->
                            inInCompactMode(
                                isInCompactMode,
                                {
                                    onIntent(HomeIntent.GoToThemeOffsetIntent)
                                },
                                {
                                    navHostController.safeNavigation(HomeNestedNavigationDirection.ThemeOffset)
                                },
                            )

                        ListAction.GoToThemeFontFamilyAction ->
                            inInCompactMode(
                                isInCompactMode,
                                {
                                    onIntent(HomeIntent.GoToThemeFontFamilyIntent)
                                },
                                {
                                    navHostController.safeNavigation(HomeNestedNavigationDirection.ThemeFontFamily)
                                },
                            )

                        is ListAction.SaveAction -> {
                            onIntent(HomeIntent.SaveIntent(action.packageName))
                        }
                    }
                },
            )
        },
        secondaryContent = { modifier ->
            HomeNestedNavigationGraph(
                navController = navHostController,
            ) { action ->
                when (action) {
                    HomeNestedAction.GoToAboutAction ->
                        inInCompactMode(
                            isInCompactMode,
                            {
                                onIntent(HomeIntent.GoToAboutIntent)
                            },
                            {
                                navHostController.safeNavigation(HomeNestedNavigationDirection.About)
                            },
                        )
                }
            }
        },
    )
}
