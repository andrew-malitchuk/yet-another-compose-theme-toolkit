package dev.yactt.presentation.feature.home.source.list

sealed interface ListAction {
    data object GoToSettingsAction : ListAction

    data object GoToAboutAction : ListAction

    data class SaveAction(
        val packageName: String,
    ) : ListAction

    data object GoToThemeColorAction : ListAction

    data object GoToThemeTypographyAction : ListAction

    data object GoToThemeFontSize : ListAction

    data object GoToThemeFontFamilyAction : ListAction

    data object GoToThemeSize : ListAction

    data object GoToThemeLineSize : ListAction

    data object GoToThemeOffset : ListAction
}
