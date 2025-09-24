package dev.yactt.presentation.feature.home.core.structure

import dev.yactt.presentation.core.platform.core.convertor.ThemeConfiguratorConvertor
import dev.yactt.presentation.core.platform.core.structure.AttributeStructure
import dev.yactt.presentation.core.platform.core.structure.CoreStructure
import dev.yactt.presentation.core.platform.core.structure.ProviderStructure
import dev.yactt.presentation.core.platform.filesystem.Fs
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.color.ColorConfiguratorState
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.font.FontFamilyConfiguratorState
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfiguratorState
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.typography.TypographyConfiguratorState
import dev.yactt.presentation.feature.theme.color.core.convertor.ColorConvertor
import dev.yactt.presentation.feature.theme.fontfamily.core.convertor.FontFamilyConvertor
import dev.yactt.presentation.feature.theme.fontsize.core.convertor.FontSizeConvertor
import dev.yactt.presentation.feature.theme.linesize.core.convertor.LineSizeConvertor
import dev.yactt.presentation.feature.theme.offset.core.convertor.OffsetConvertor
import dev.yactt.presentation.feature.theme.size.core.convertor.SizeConvertor
import dev.yactt.presentation.feature.theme.typography.core.convertor.TypographyConvertor

class Structure(
    val packageName: String,
    val isNative: Boolean,
) {
    fun getStructure(
        color: ColorConfiguratorState,
        fontSize: SizeConfiguratorState,
        lineHeight: SizeConfiguratorState,
        size: SizeConfiguratorState,
        spacing: SizeConfiguratorState,
        fontFamily: FontFamilyConfiguratorState,
        typography: TypographyConfiguratorState,
    ): Map<String, Any> =
        Fs().generateStructure(
            basePackagePath = packageName,
            coreStructure =
                generateCoreStructure(
                    color,
                    fontSize,
                    lineHeight,
                    size,
                    spacing,
                    fontFamily,
                    typography,
                ),
            attributeStructure =
                generateAttributeStructure(
                    color,
                    fontSize,
                    lineHeight,
                    size,
                    spacing,
                    fontFamily,
                    typography,
                ),
            providerStructure = generateProviderStructure(),
        )

    private fun generateCoreStructure(
        color: ColorConfiguratorState,
        fontSize: SizeConfiguratorState,
        lineHeight: SizeConfiguratorState,
        size: SizeConfiguratorState,
        spacing: SizeConfiguratorState,
        fontFamily: FontFamilyConfiguratorState,
        typography: TypographyConfiguratorState,
    ): CoreStructure =
        CoreStructure.generateStructure(
            theme =
                ThemeConfiguratorConvertor(
                    packageName,
                    "Theme",
                ).generateArtifact(null),
            themeColor =
                ColorConvertor(
                    packageName,
                    "ThemeColor",
                ).generateArtifact(color),
            themeFontSize =
                FontSizeConvertor(
                    packageName,
                    "ThemeFontSize",
                ).generateArtifact(fontSize),
            themeLineHeight =
                LineSizeConvertor(
                    packageName,
                    "ThemeLineHeight",
                ).generateArtifact(lineHeight),
            themeSize =
                SizeConvertor(
                    packageName,
                    "ThemeSize",
                ).generateArtifact(size),
            themeSpacing =
                OffsetConvertor(
                    packageName,
                    "ThemeSpacing",
                ).generateArtifact(spacing),
            themeFontFamily =
                FontFamilyConvertor(
                    packageName,
                    "ThemeFontFamily",
                    isNative = isNative,
                ).generateArtifact(fontFamily),
            themeTypography =
                TypographyConvertor(
                    packageName,
                    "ThemeTypography",
                ).generateArtifact(typography),
        )

    private fun generateAttributeStructure(
        color: ColorConfiguratorState,
        fontSize: SizeConfiguratorState,
        lineHeight: SizeConfiguratorState,
        size: SizeConfiguratorState,
        spacing: SizeConfiguratorState,
        fontFamily: FontFamilyConfiguratorState,
        typography: TypographyConfiguratorState,
    ): AttributeStructure =
        AttributeStructure.generateStructure(
            themeColor =
                ColorConvertor(
                    packageName,
                    "ThemeColor",
                ).generateAttribute(color),
            themeFontSize =
                FontSizeConvertor(
                    packageName,
                    "ThemeFontSize",
                ).generateAttribute(fontSize),
            themeLineHeight =
                LineSizeConvertor(
                    packageName,
                    "ThemeLineHeight",
                ).generateAttribute(lineHeight),
            themeSize =
                SizeConvertor(
                    packageName,
                    "ThemeSize",
                ).generateAttribute(size),
            themeSpacing =
                OffsetConvertor(
                    packageName,
                    "ThemeSpacing",
                ).generateAttribute(spacing),
            themeFontFamily =
                FontFamilyConvertor(
                    packageName,
                    "ThemeFontFamily",
                    isNative = isNative,
                ).generateAttribute(fontFamily),
            themeTypography =
                TypographyConvertor(
                    packageName,
                    "ThemeTypography",
                ).generateAttribute(typography),
        )

    private fun generateProviderStructure(): ProviderStructure =
        ProviderStructure.generateStructure(
            theme =
                ThemeConfiguratorConvertor(
                    packageName,
                    "AppTheme",
                ).generateProvider(),
            themeColor =
                ColorConvertor(
                    packageName,
                    "ThemeColor",
                ).generateProvider(),
            themeFontSize =
                FontSizeConvertor(
                    packageName,
                    "ThemeFontSize",
                ).generateProvider(),
            themeLineHeight =
                LineSizeConvertor(
                    packageName,
                    "ThemeLineHeight",
                ).generateProvider(),
            themeSize =
                SizeConvertor(
                    packageName,
                    "ThemeSize",
                ).generateProvider(),
            themeSpacing =
                OffsetConvertor(
                    packageName,
                    "ThemeSpacing",
                ).generateProvider(),
            themeFontFamily =
                FontFamilyConvertor(
                    packageName,
                    "ThemeFontFamily",
                    isNative = isNative,
                ).generateProvider(),
            themeTypography =
                TypographyConvertor(
                    packageName,
                    "ThemeTypography",
                ).generateProvider(),
        )
}
