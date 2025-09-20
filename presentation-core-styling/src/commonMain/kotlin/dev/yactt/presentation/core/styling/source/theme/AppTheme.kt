package dev.yactt.presentation.core.styling.source.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.yactt.presentation.core.localisation.Language
import dev.yactt.presentation.core.localisation.source.locale.getLocalisation
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.styling.source.attribute.AttributeTypography
import dev.yactt.presentation.core.styling.source.attribute.attributeFontSize
import dev.yactt.presentation.core.styling.source.attribute.attributeLineHeight
import dev.yactt.presentation.core.styling.source.attribute.attributeSize
import dev.yactt.presentation.core.styling.source.attribute.attributeSpacing
import dev.yactt.presentation.core.styling.source.attribute.color.attributeDarkColorPalette
import dev.yactt.presentation.core.styling.source.attribute.color.attributeLightColorPalette
import dev.yactt.presentation.core.styling.source.provider.LocalThemeColor
import dev.yactt.presentation.core.styling.source.provider.LocalThemeFontSize
import dev.yactt.presentation.core.styling.source.provider.LocalThemeLineHeight
import dev.yactt.presentation.core.styling.source.provider.LocalThemeSize
import dev.yactt.presentation.core.styling.source.provider.LocalThemeSpacing
import dev.yactt.presentation.core.styling.source.provider.LocalThemeTypography

@Composable
fun AppTheme(
    useDarkTheme: Boolean = false,
    language: String,
    content: @Composable () -> Unit,
) {
    val currentColorPalette =
        when {
            useDarkTheme -> attributeDarkColorPalette
            else -> attributeLightColorPalette
        }
    val currentLang =
        getLocalisation(Language.entries.firstOrNull { it.iso == language } ?: Language.English)

    CompositionLocalProvider(
        LocalThemeColor provides currentColorPalette,
        LocalThemeFontSize provides attributeFontSize,
        LocalThemeSize provides attributeSize,
        LocalThemeLineHeight provides attributeLineHeight,
        LocalThemeSpacing provides attributeSpacing,
        LocalThemeTypography provides AttributeTypography(),
        LocalLocalisation provides currentLang,
        content = content,
    )
}
