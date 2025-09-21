package dev.yactt.presentation.core.ui.source.widget.miscellaneous.color

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.DialogProperties
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.core.ext.makeScrollable
import dev.yactt.presentation.core.ui.core.ext.noRippleClickable
import dev.yactt.presentation.core.ui.source.icon.Backspace
import dev.yactt.presentation.core.ui.source.icon.Hash
import dev.yactt.presentation.core.ui.source.icon.Plus
import dev.yactt.presentation.core.ui.source.icon.Trash2
import dev.yactt.presentation.core.ui.source.miscellaneous.colorpicker.ColorPickerDialog
import dev.yactt.presentation.core.ui.source.miscellaneous.colorpicker.ColorPickerType
import dev.yactt.presentation.core.ui.source.miscellaneous.colorpicker.ext.toHex
import dev.yactt.presentation.core.ui.source.widget.button.icon.primary.PrimaryIconButton
import dev.yactt.presentation.core.ui.source.widget.field.InputField
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.AnimatedDivider

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ColorConfigurator(
    modifier: Modifier = Modifier,
    state: ColorConfiguratorState = rememberColorConfiguratorState(),
    scrollableState: ScrollState = rememberScrollState(),
    onAddClick: () -> Unit = {},
    onRemoveClick: (Int) -> Unit = {},
) {
    var showColorPickerDialog: Int? by remember {
        mutableStateOf(null)
    }

    val localisation = LocalLocalisation.current

    ColorPickerDialog(
        show = showColorPickerDialog != null,
        onPickedColor = { color ->
            showColorPickerDialog?.let {
                state[it] =
                    ColorConfiguratorData(
                        name = mutableStateOf(color.toHex()),
                        hex = mutableStateOf(color.toHex()),
                    )
            }
            showColorPickerDialog = null
        },
        onDismissRequest = {
            showColorPickerDialog = null
        },
        properties = DialogProperties(),
        type = ColorPickerType.Classic(initialColor = Theme.color.accent0),
    )

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
                    ColorItem(
                        modifier =
                            Modifier
                                .size(Theme.size.size48)
                                .padding(Theme.spacing.space8)
                                .noRippleClickable(
                                    onClick = {
                                        showColorPickerDialog = index
                                    },
                                ),
                        color = data.hex.value.toColor(),
                    )
                    InputField(
                        leadingIcon = {
                            Icon(
                                imageVector = Hash,
                                contentDescription = null,
                                tint = Theme.color.neutral2,
                                modifier = Modifier.size(Theme.size.size16),
                            )
                        },
                        value = data.hex.value,
                        onValueChange = { newValue ->
                            data.hex.value = newValue
                        },
                        modifier =
                            Modifier
                                .width(Theme.size.size128)
                                .padding(Theme.spacing.space8),
                        isError = false,
                        singleLine = true,
                        maxLines = 1,
                        textStyle = Theme.typography.button,
                        keyboardOptions = KeyboardOptions.Default,
                        keyboardActions = KeyboardActions.Default,
                    )
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
fun rememberColorConfiguratorState(): ColorConfiguratorState = remember { ColorConfiguratorState() }

class ColorConfiguratorState {
    val values = mutableStateListOf<ColorConfiguratorData>()

    fun add(colorConfiguratorData: ColorConfiguratorData) {
        values.add(colorConfiguratorData)
    }

    fun remove(index: Int) {
        values.removeAt(index)
    }

    operator fun set(
        index: Int,
        colorConfiguratorData: ColorConfiguratorData,
    ) {
        values[index] = colorConfiguratorData
    }
}

data class ColorConfiguratorData(
    val name: MutableState<String> = mutableStateOf(""),
    val hex: MutableState<String> = mutableStateOf(""),
)

fun String.toColor(): Color =
    try {
        val hex = this.removePrefix("#")
        val colorLong =
            when (hex.length) {
                6 -> 0xFF000000 or hex.toLong(16) // Add full opacity
                8 -> hex.toLong(16)
                else -> throw IllegalArgumentException("Invalid color hex string: $this")
            }
        Color(colorLong)
    } catch (ex: Exception) {
        Color.Transparent
    }
