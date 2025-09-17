package dev.yactt.presentation.core.platform.core.structure

data class ProviderStructure(
    val theme: Pair<String, String>,
    val themeColor: Pair<String, String>,
    val themeFontSize: Pair<String, String>,
    val themeLineHeight: Pair<String, String>,
    val themeSize: Pair<String, String>,
    val themeSpacing: Pair<String, String>,
    val themeFontFamily: Pair<String, String>,
    val themeTypography: Pair<String, String>,
) {
    companion object {
        fun generateStructure(
            theme: String,
            themeColor: String,
            themeFontSize: String,
            themeLineHeight: String,
            themeSize: String,
            themeSpacing: String,
            themeFontFamily: String,
            themeTypography: String,
        ): ProviderStructure =
            ProviderStructure(
                theme = "AppTheme.kt" to theme,
                themeColor = "ThemeColorProvider.kt" to themeColor,
                themeFontSize = "ThemeFontSizeProvider.kt" to themeFontSize,
                themeLineHeight = "ThemeLineHeightProvider.kt" to themeLineHeight,
                themeSize = "ThemeSizeProvider.kt" to themeSize,
                themeSpacing = "ThemeSpacingProvider.kt" to themeSpacing,
                themeFontFamily = "ThemeFontFamilyProvider.kt" to themeFontFamily,
                themeTypography = "ThemeTypographyProvider.kt" to themeTypography,
            )

        fun ProviderStructure.generateMapStructure(): Map<String, Any> =
            mapOf(
                theme.first to theme.second,
                themeColor.first to themeColor.second,
                themeFontSize.first to themeFontSize.second,
                themeLineHeight.first to themeLineHeight.second,
                themeSize.first to themeSize.second,
                themeSpacing.first to themeSpacing.second,
                themeFontFamily.first to themeFontFamily.second,
                themeTypography.first to themeTypography.second,
            )
    }
}
