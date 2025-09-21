package dev.yactt.presentation.core.ui.source.widget.miscellaneous.size

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.core.ext.makeScrollable
import dev.yactt.presentation.core.ui.source.icon.Backspace
import dev.yactt.presentation.core.ui.source.icon.Minus
import dev.yactt.presentation.core.ui.source.icon.Plus
import dev.yactt.presentation.core.ui.source.icon.Trash2
import dev.yactt.presentation.core.ui.source.widget.button.icon.primary.PrimaryIconButton
import dev.yactt.presentation.core.ui.source.widget.field.InputField
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.AnimatedDivider

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SizeConfigurator(
    modifier: Modifier = Modifier,
    state: SizeConfiguratorState = rememberSizeConfiguratorState(),
    scrollableState: ScrollState = rememberScrollState(),
    onAddClick: () -> Unit = {},
    onRemoveClick: (Int) -> Unit = {},
    onDecreaseClick: () -> Unit = {},
    onIncreaseClick: () -> Unit = {},
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
                        icon = Minus,
                        onClick = {
                            onDecreaseClick()
                            data.decrease()
                        },
                    )
                    InputField(
                        value = data.size.value.toString(),
                        onValueChange = { newValue ->
                            data.size.value = newValue.toIntOrNull() ?: 0
                        },
                        modifier =
                            Modifier
                                .width(72.dp)
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
                        icon = Plus,
                        onClick = {
                            onIncreaseClick()
                            data.increase()
                        },
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
fun rememberSizeConfiguratorState(): SizeConfiguratorState = remember { SizeConfiguratorState() }

class SizeConfiguratorState {
    val values = mutableStateListOf<SizeConfiguratorData>()

    fun add(sizeConfiguratorData: SizeConfiguratorData) {
        values.add(sizeConfiguratorData)
    }

    fun remove(index: Int) {
        values.removeAt(index)
    }

    fun decrease(index: Int) {
        values[index] =
            values[index].copy(
                size =
                    mutableStateOf(
                        values[index].size.value - 1,
                    ),
            )
    }

    fun increase(index: Int) {
        values[index] =
            values[index].copy(
                size =
                    mutableStateOf(
                        values[index].size.value + 1,
                    ),
            )
    }

    operator fun set(
        index: Int,
        sizeConfiguratorData: SizeConfiguratorData,
    ) {
        values[index] = sizeConfiguratorData
    }
}

data class SizeConfiguratorData(
    val name: MutableState<String> = mutableStateOf(""),
    val size: MutableState<Int> = mutableStateOf(10),
) {
    fun decrease() {
        if (size.value > 0f) size.value -= 1
    }

    fun increase() {
        size.value += 1
    }
}
