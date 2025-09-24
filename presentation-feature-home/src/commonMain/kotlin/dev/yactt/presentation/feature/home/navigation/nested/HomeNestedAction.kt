package dev.yactt.presentation.feature.home.navigation.nested

sealed interface HomeNestedAction {
    data object GoToAboutAction : HomeNestedAction
}
