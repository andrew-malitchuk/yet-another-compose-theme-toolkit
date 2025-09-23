package dev.yactt.presentation.feature.home.source.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.core.ext.makeScrollable
import dev.yactt.presentation.core.ui.source.icon.ArrowsOutLineVertical
import dev.yactt.presentation.core.ui.source.icon.FloppyDisk
import dev.yactt.presentation.core.ui.source.icon.FrameCorners
import dev.yactt.presentation.core.ui.source.icon.Package
import dev.yactt.presentation.core.ui.source.icon.Palette
import dev.yactt.presentation.core.ui.source.icon.Ruler
import dev.yactt.presentation.core.ui.source.icon.TextAa
import dev.yactt.presentation.core.ui.source.icon.TextT
import dev.yactt.presentation.core.ui.source.layout.CompactContainer
import dev.yactt.presentation.core.ui.source.widget.button.icon.primary.PrimaryIconButton
import dev.yactt.presentation.core.ui.source.widget.customsnackbar.rememberSnackBarState
import dev.yactt.presentation.core.ui.source.widget.item.primary.PrimaryItem
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.AnimatedDivider
import dev.yactt.presentation.feature.home.core.components.widget.HomeHeader
import dev.yactt.presentation.feature.home.core.components.widget.HomeHeaderAction
import dev.yactt.presentation.feature.home.core.configure.ListItem

@Composable
fun ListView(
    modifier: Modifier = Modifier,
    isInCompactMode: Boolean,
    onAction: (ListAction) -> Unit,
) {
    val localisation = LocalLocalisation.current

    val scrollableState = rememberScrollState()

    var selectedItem: ListItem? by remember { mutableStateOf(null) }

    val packageName = remember { mutableStateOf("") }

    val dialogState = rememberSnackBarState()

    CompactContainer(
        modifier = modifier,
        isInCompactMode = isInCompactMode,
        headerContent = {
            HomeHeader(
                packageName = packageName,
                isDividerVisible = scrollableState.canScrollBackward,
            ) { action ->
                when (action) {
                    HomeHeaderAction.GoToSettings -> onAction(ListAction.GoToSettingsAction)
                }
            }
        },
        mainContent = {
            Column(
                modifier =
                    Modifier
                        .padding(
                            vertical = Theme.spacing.space8,
                        ),
            ) {
                Column(
                    modifier =
                        Modifier
                            .padding(horizontal = Theme.spacing.space8)
                            .makeScrollable(state = scrollableState)
                            .weight(1f),
                ) {
                    PrimaryItem(
                        modifier = Modifier,
                        icon = Palette,
                        text = localisation.home.palette,
                        isSelected = selectedItem == ListItem.Palette,
                    ) {
                        selectedItem = ListItem.Palette
                        onAction(ListAction.GoToThemeColorAction)
                    }
                    PrimaryItem(
                        modifier = Modifier,
                        icon = FrameCorners,
                        text = localisation.home.size,
                        isSelected = selectedItem == ListItem.Size,
                    ) {
                        selectedItem = ListItem.Size
                        onAction(ListAction.GoToThemeSize)
                    }
                    PrimaryItem(
                        modifier = Modifier,
                        icon = Ruler,
                        text = localisation.home.offset,
                        isSelected = selectedItem == ListItem.Offset,
                    ) {
                        selectedItem = ListItem.Offset
                        onAction(ListAction.GoToThemeOffset)
                    }

                    PrimaryItem(
                        modifier = Modifier,
                        icon = TextT,
                        text = localisation.home.fontSize,
                        isSelected = selectedItem == ListItem.FontSize,
                    ) {
                        selectedItem = ListItem.FontSize
                        onAction(ListAction.GoToThemeFontSize)
                    }
                    PrimaryItem(
                        modifier = Modifier,
                        icon = ArrowsOutLineVertical,
                        text = localisation.home.lineHeight,
                        isSelected = selectedItem == ListItem.LineHeight,
                    ) {
                        selectedItem = ListItem.LineHeight
                        onAction(ListAction.GoToThemeLineSize)
                    }

                    PrimaryItem(
                        modifier = Modifier,
                        icon = Package,
                        text = localisation.home.fontFamily,
                        isSelected = selectedItem == ListItem.FontFamily,
                    ) {
                        selectedItem = ListItem.FontFamily
                        onAction(ListAction.GoToThemeFontFamilyAction)
                    }
                    PrimaryItem(
                        modifier = Modifier,
                        icon = TextAa,
                        text = localisation.home.typography,
                        isSelected = selectedItem == ListItem.Typography,
                    ) {
                        selectedItem = ListItem.Typography
                        onAction(ListAction.GoToThemeTypographyAction)
                    }
                }
                AnimatedDivider(
                    modifier =
                        Modifier
                            .fillMaxWidth(),
                    isVisible = scrollableState.canScrollForward,
                )
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                ) {
                    Spacer(
                        modifier =
                            Modifier
                                .weight(1f),
                    )
                    PrimaryIconButton(
                        modifier =
                            Modifier
                                .padding(Theme.spacing.space8),
                        icon = FloppyDisk,
                        onClick = {
                            if (packageName.value.isNotEmpty()) {
                                onAction(ListAction.SaveAction(packageName.value))
                            } else {
                                dialogState.showSnackBar(localisation.general.errorPackage)
                            }
                        },
                    )
                }
            }
        },
    )
}
