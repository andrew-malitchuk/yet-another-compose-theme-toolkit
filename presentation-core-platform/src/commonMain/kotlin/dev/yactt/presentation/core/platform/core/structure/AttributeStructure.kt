package dev.yactt.presentation.core.platform.core.structure

data class AttributeStructure(
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
            themeColor: String,
            themeFontSize: String,
            themeLineHeight: String,
            themeSize: String,
            themeSpacing: String,
            themeFontFamily: String,
            themeTypography: String,
        ): AttributeStructure =
            AttributeStructure(
                themeColor = "ThemeColor.kt" to themeColor,
                themeFontSize = "ThemeFontSize.kt" to themeFontSize,
                themeLineHeight = "ThemeLineHeight.kt" to themeLineHeight,
                themeSize = "ThemeSize.kt" to themeSize,
                themeSpacing = "ThemeSpacing.kt" to themeSpacing,
                themeFontFamily = "ThemeFontFamily.kt" to themeFontFamily,
                themeTypography = "ThemeTypography.kt" to themeTypography,
            )

        fun AttributeStructure.generateMapStructure(): Map<String, Any> =
            mapOf(
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
