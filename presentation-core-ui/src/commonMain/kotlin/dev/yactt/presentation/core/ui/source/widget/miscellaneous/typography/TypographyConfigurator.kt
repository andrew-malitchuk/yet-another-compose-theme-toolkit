package dev.yactt.presentation.core.ui.source.widget.miscellaneous.typography

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.core.ext.makeScrollable
import dev.yactt.presentation.core.ui.source.icon.Backspace
import dev.yactt.presentation.core.ui.source.icon.Pen
import dev.yactt.presentation.core.ui.source.icon.Plus
import dev.yactt.presentation.core.ui.source.icon.Trash2
import dev.yactt.presentation.core.ui.source.widget.button.icon.primary.PrimaryIconButton
import dev.yactt.presentation.core.ui.source.widget.field.InputField
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.AnimatedDivider

@Composable
fun TypographyConfigurator(
    modifier: Modifier = Modifier,
    state: TypographyConfiguratorState = rememberTypographyConfiguratorState(),
    scrollableState: ScrollState = rememberScrollState(),
    onAddClick: () -> Unit = {},
    onRemoveClick: (Int) -> Unit = {},
    onPickClick: ((Int, TypographyDataAttribute) -> Unit) = { _, _ -> },
) {
    val localisation = LocalLocalisation.current

    Column(
        modifier =
            modifier
                .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier =
                modifier
                    .fillMaxWidth()
                    .makeScrollable(state = scrollableState)
                    .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            state.values.forEachIndexed { index, data ->

                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(
                                top = Theme.spacing.space8,
                            ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    InputField(
                        value = data.name.value,
                        onValueChange = { newValue ->
                            data.name.value = newValue
                        },
                        placeholder = {
                            Text(
                                text = localisation.general.name,
                                style = Theme.typography.button,
                                color = Theme.color.neutral2,
                            )
                        },
                        modifier =
                            Modifier
                                .weight(1f)
                                .padding(Theme.spacing.space8),
                        isError = false,
                        singleLine = true,
                        maxLines = 1,
                        textStyle = Theme.typography.button,
                        keyboardOptions = KeyboardOptions.Default,
                        keyboardActions = KeyboardActions.Default,
                    )
                    PrimaryIconButton(
                        modifier =
                            Modifier
                                .padding(Theme.spacing.space8),
                        icon = Backspace,
                        onClick = {
                            onRemoveClick(index)
                        },
                    )
                }
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    InputField(
                        value = data.fontSize.value,
                        onValueChange = { newValue ->
                            data.fontSize.value = newValue
                        },
                        placeholder = {
                            Text(
                                text = localisation.home.fontSize,
                                style = Theme.typography.button,
                                color = Theme.color.neutral2,
                            )
                        },
                        enabled = false,
                        modifier =
                            Modifier
                                .weight(1f)
                                .padding(Theme.spacing.space8),
                        isError = false,
                        singleLine = true,
                        maxLines = 1,
                        textStyle = Theme.typography.button,
                        keyboardOptions = KeyboardOptions.Default,
                        keyboardActions = KeyboardActions.Default,
                    )
                    PrimaryIconButton(
                        modifier =
                            Modifier
                                .padding(Theme.spacing.space8),
                        icon = Pen,
                        onClick = {
                            onPickClick(index, TypographyDataAttribute.FONT_SIZE)
                        },
                    )
                }
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    InputField(
                        value = data.lineHeight.value,
                        onValueChange = { newValue ->
                            data.lineHeight.value = newValue
                        },
                        placeholder = {
                            Text(
                                text = localisation.home.lineHeight,
                                style = Theme.typography.button,
                                color = Theme.color.neutral2,
                            )
                        },
                        enabled = false,
                        modifier =
                            Modifier
                                .weight(1f)
                                .padding(Theme.spacing.space8),
                        isError = false,
                        singleLine = true,
                        maxLines = 1,
                        textStyle = Theme.typography.button,
                        keyboardOptions = KeyboardOptions.Default,
                        keyboardActions = KeyboardActions.Default,
                    )
                    PrimaryIconButton(
                        modifier =
                            Modifier
                                .padding(Theme.spacing.space8),
                        icon = Pen,
                        onClick = {
                            onPickClick(index, TypographyDataAttribute.LINE_HEIGHT)
                        },
                    )
                }
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    InputField(
                        value = data.fontFamily.value,
                        onValueChange = { newValue ->
                            data.fontFamily.value = newValue
                        },
                        placeholder = {
                            Text(
                                text = localisation.home.fontFamily,
                                style = Theme.typography.button,
                                color = Theme.color.neutral2,
                            )
                        },
                        enabled = false,
                        modifier =
                            Modifier
                                .weight(1f)
                                .padding(Theme.spacing.space8),
                        isError = false,
                        singleLine = true,
                        maxLines = 1,
                        textStyle = Theme.typography.button,
                        keyboardOptions = KeyboardOptions.Default,
                        keyboardActions = KeyboardActions.Default,
                    )
                    PrimaryIconButton(
                        modifier =
                            Modifier
                                .padding(Theme.spacing.space8),
                        icon = Pen,
                        onClick = {
                            onPickClick(index, TypographyDataAttribute.FONT_FAMILY)
                        },
                    )
                }
                Box(
                    modifier =
                        Modifier
                            .height(Theme.spacing.space8)
                            .width(Theme.spacing.space32)
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(Theme.color.neutral2),
                )
            }
            PrimaryIconButton(
                modifier =
                    Modifier.padding(
                        top = Theme.spacing.space8,
                    ),
                icon = Plus,
                onClick = onAddClick,
            )
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
            verticalAlignment = Alignment.CenterVertically,
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
                icon = Trash2,
                onClick = {
                    state.values.clear()
                },
            )
        }
    }
}

@Composable
fun rememberTypographyConfiguratorState(): TypographyConfiguratorState = remember { TypographyConfiguratorState() }

class TypographyConfiguratorState {
    val values = mutableStateListOf<TypographyConfiguratorData>()

    fun add(typographyConfiguratorData: TypographyConfiguratorData) {
        values.add(typographyConfiguratorData)
    }

    fun remove(index: Int) {
        values.removeAt(index)
    }

    operator fun set(
        index: Int,
        typographyConfiguratorData: TypographyConfiguratorData,
    ) {
        values[index] = typographyConfiguratorData
    }
}

data class TypographyConfiguratorData(
    val name: MutableState<String> = mutableStateOf(""),
    val fontSize: MutableState<String> = mutableStateOf(""),
    val lineHeight: MutableState<String> = mutableStateOf(""),
    val fontFamily: MutableState<String> = mutableStateOf(""),
)

enum class TypographyDataAttribute {
    FONT_SIZE,
    LINE_HEIGHT,
    FONT_FAMILY,
}
