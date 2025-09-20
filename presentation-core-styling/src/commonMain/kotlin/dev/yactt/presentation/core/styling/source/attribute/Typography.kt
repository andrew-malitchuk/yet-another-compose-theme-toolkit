package dev.yactt.presentation.core.styling.source.attribute

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.yactt.presentation.core.styling.core.ThemeTypography
import org.jetbrains.compose.resources.Font
import yet_another_compose_theme_toolkit.presentation_core_styling.generated.resources.Res
import yet_another_compose_theme_toolkit.presentation_core_styling.generated.resources.opensans_regular
import yet_another_compose_theme_toolkit.presentation_core_styling.generated.resources.oswald_regular

@Composable
fun OswaldFontFamily() =
    FontFamily(
        Font(
            Res.font.oswald_regular,
            weight = FontWeight.Black,
            style = FontStyle.Normal,
        ),
    )

@Composable
fun OpenSansFontFamily() =
    FontFamily(
        Font(
            Res.font.opensans_regular,
            weight = FontWeight.Black,
            style = FontStyle.Normal,
        ),
    )

@Composable
fun AttributeTypography() =
    ThemeTypography(
        display =
            TextStyle(
                fontSize = attributeFontSize.display,
                lineHeight = attributeLineHeight.display,
                fontWeight = FontWeight.Normal,
                fontFamily = OswaldFontFamily(),
            ),
        headline =
            TextStyle(
                fontSize = attributeFontSize.headline,
                lineHeight = attributeLineHeight.headline,
                fontWeight = FontWeight.Normal,
                fontFamily = OswaldFontFamily(),
            ),
        title =
            TextStyle(
                fontSize = attributeFontSize.title,
                lineHeight = attributeLineHeight.title,
                fontWeight = FontWeight.Medium,
                fontFamily = OpenSansFontFamily(),
            ),
        subHeading =
            TextStyle(
                fontSize = attributeFontSize.subHeading,
                lineHeight = attributeLineHeight.subHeading,
                fontWeight = FontWeight.Normal,
                fontFamily = OpenSansFontFamily(),
            ),
        body =
            TextStyle(
                fontSize = attributeFontSize.body,
                lineHeight = attributeLineHeight.body,
                fontWeight = FontWeight.Normal,
                fontFamily =
                    OpenSansFontFamily(),
            ),
        caption =
            TextStyle(
                fontSize = attributeFontSize.caption,
                lineHeight = attributeLineHeight.caption,
                fontWeight = FontWeight.Normal,
                fontFamily = OpenSansFontFamily(),
            ),
        button =
            TextStyle(
                fontSize = attributeFontSize.button,
                lineHeight = attributeLineHeight.button,
                fontFamily = OpenSansFontFamily(),
            ),
    )
