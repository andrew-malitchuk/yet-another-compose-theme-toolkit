package dev.yactt.presentation.feature.theme.typography.source.typography

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.core.ext.makeScrollable
import dev.yactt.presentation.core.ui.source.dialog.CustomSideDrawerOverlay
import dev.yactt.presentation.core.ui.source.icon.ArrowsOutLineVertical
import dev.yactt.presentation.core.ui.source.icon.Package
import dev.yactt.presentation.core.ui.source.icon.TextT
import dev.yactt.presentation.core.ui.source.layout.CompactContainer
import dev.yactt.presentation.core.ui.source.widget.header.SimpleHeader
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.typography.TypographyConfigurator
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.typography.TypographyDataAttribute
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi.ThemeFontFamilyState
import dev.yactt.presentation.feature.theme.fontsize.source.fontsize.mvi.ThemeFontSizeState
import dev.yactt.presentation.feature.theme.linesize.source.linesize.mvi.ThemeLineSizeState
import dev.yactt.presentation.feature.theme.typography.core.component.ValuePicker
import dev.yactt.presentation.feature.theme.typography.source.typography.mvi.ThemeTypographyIntent
import dev.yactt.presentation.feature.theme.typography.source.typography.mvi.ThemeTypographyState

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ThemeTypographyView(
    modifier: Modifier = Modifier,
    isInCompactMode: Boolean,
    state: ThemeTypographyState,
    themeFontSizeState: ThemeFontSizeState,
    themeLineSizeState: ThemeLineSizeState,
    themeFontFamilyState: ThemeFontFamilyState,
    onIntent: (ThemeTypographyIntent) -> Unit,
) {
    val localisation = LocalLocalisation.current
    val scrollableState = rememberScrollState()

    var isDrawerOpen by remember {
        mutableStateOf(false)
    }

    var pickedType: Pair<Int, TypographyDataAttribute>? by remember {
        mutableStateOf(null)
    }

    fun content(pickedType: TypographyDataAttribute?): List<String> =
        when (pickedType) {
            TypographyDataAttribute.FONT_SIZE -> themeFontSizeState.content.values.map { it.name.value }
            TypographyDataAttribute.LINE_HEIGHT -> themeLineSizeState.content.values.map { it.name.value }
            TypographyDataAttribute.FONT_FAMILY -> themeFontFamilyState.content.values.map { it.name.value }
            else -> emptyList()
        }

    fun icon(pickedType: TypographyDataAttribute?): ImageVector? =
        when (pickedType) {
            TypographyDataAttribute.FONT_SIZE -> TextT
            TypographyDataAttribute.LINE_HEIGHT -> ArrowsOutLineVertical
            TypographyDataAttribute.FONT_FAMILY -> Package
            else -> null
        }

    fun header(pickedType: TypographyDataAttribute?): String? =
        when (pickedType) {
            TypographyDataAttribute.FONT_SIZE -> localisation.theme.fontSize
            TypographyDataAttribute.LINE_HEIGHT -> localisation.theme.linesize
            TypographyDataAttribute.FONT_FAMILY -> localisation.theme.fontFamily
            else -> null
        }

    CompactContainer(
        modifier =
            modifier
                .background(Theme.color.neutral0)
                .statusBarsPadding(),
        isInCompactMode = isInCompactMode,
        headerContent = {
            SimpleHeader(
                title = localisation.theme.typography,
                isDividerVisible = scrollableState.canScrollBackward,
                onNavClick = {
                    onIntent(ThemeTypographyIntent.OnBackClickIntent)
                },
            )
        },
        mainContent = {
            CustomSideDrawerOverlay(
                isDrawerOpen = isDrawerOpen,
                onDismiss = {
                    isDrawerOpen = false
                    pickedType = null
                },
                drawerContent = {
                    ValuePicker(
                        data = content(pickedType?.second),
                        title = localisation.general.nothingTitle,
                        description = localisation.general.nothingDescription,
                        header = header(pickedType?.second) ?: "",
                        icon = icon(pickedType?.second),
                    ) { selected ->
                        isDrawerOpen = false

                        when (pickedType?.second) {
                            TypographyDataAttribute.FONT_SIZE ->
                                pickedType?.first?.let {
                                    state.content.values[it]
                                        .fontSize.value = selected
                                }

                            TypographyDataAttribute.LINE_HEIGHT ->
                                pickedType?.first?.let {
                                    state.content.values[it]
                                        .lineHeight.value = selected
                                }

                            TypographyDataAttribute.FONT_FAMILY ->
                                pickedType?.first?.let {
                                    state.content.values[it]
                                        .fontFamily.value = selected
                                }

                            null -> Unit
                        }
                        pickedType = null
                    }
                },
                content = {
                    Column(
                        modifier =
                            modifier
                                .fillMaxSize()
                                .background(Theme.color.neutral0)
                                .padding(horizontal = Theme.spacing.space16)
                                .makeScrollable(),
                        verticalArrangement = Arrangement.spacedBy(Theme.spacing.space8),
                    ) {
                        TypographyConfigurator(
                            modifier = Modifier.weight(1f),
                            state = state.content,
                            scrollableState = scrollableState,
                            onAddClick = {
                                onIntent(
                                    ThemeTypographyIntent.AddTypographyIntent,
                                )
                            },
                            onRemoveClick = {
                                onIntent(
                                    ThemeTypographyIntent.RemoveTypographyIntent(it),
                                )
                            },
                            onPickClick = { index, type ->
                                isDrawerOpen = true
                                pickedType = index to type
                            },
                        )
                    }
                },
            )
        },
    )
}
