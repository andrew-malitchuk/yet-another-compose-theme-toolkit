package dev.yactt.presentation.core.ui.source.widget.miscellaneous.font

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.core.ext.makeScrollable
import dev.yactt.presentation.core.ui.source.icon.Backspace
import dev.yactt.presentation.core.ui.source.icon.Plus
import dev.yactt.presentation.core.ui.source.icon.Question
import dev.yactt.presentation.core.ui.source.icon.Trash2
import dev.yactt.presentation.core.ui.source.widget.button.icon.primary.PrimaryIconButton
import dev.yactt.presentation.core.ui.source.widget.button.text.TextButton
import dev.yactt.presentation.core.ui.source.widget.field.InputField
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.AnimatedDivider

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FontFamilyConfigurator(
    modifier: Modifier = Modifier,
    state: FontFamilyConfiguratorState = rememberFontFamilyConfiguratorState(),
    scrollableState: ScrollState = rememberScrollState(),
    onAddClick: () -> Unit = {},
    onRemoveClick: (Int) -> Unit = {},
) {
    val localisation = LocalLocalisation.current

    val weights = FontWeightAttribute.entries.toList()
    val styles = FontStyleAttribute.entries.toList()

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
            state.values.forEachIndexed { index, value ->
                key(value) {
                    //
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
                            value = value.name.value,
                            onValueChange = { newValue ->
                                value.name.value = newValue
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
                    //
                    Row(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Theme.spacing.space8)
                                .wrapContentHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            modifier =
                                Modifier
                                    .fillMaxHeight()
                                    .align(Alignment.Top)
                                    .padding(top = Theme.spacing.space8),
                            text = localisation.theme.fontWeight,
                            style = Theme.typography.body,
                            color = Theme.color.neutral1,
                        )

                        Spacer(Modifier.width(Theme.spacing.space8))

                        FlowRow(
                            modifier = Modifier.weight(1f),
                            horizontalArrangement =
                                Arrangement.spacedBy(
                                    0.dp,
                                    Alignment.End,
                                ),
                            maxItemsInEachRow = 5,
                        ) {
                            weights.forEach { w ->
                                key("w_${w.name}_$index") {
                                    TextButton(
                                        text = w.name,
                                        isSelected = w == value.weight.value,
                                        onClick = {
                                            value.weight.value = w
                                        },
                                    )
                                }
                            }
                        }
                    }
                    Row(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Theme.spacing.space8)
                                .wrapContentHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = localisation.theme.style,
                            style = Theme.typography.body,
                            color = Theme.color.neutral1,
                        )

                        Spacer(Modifier.width(Theme.spacing.space8))

                        FlowRow(
                            modifier = Modifier.weight(1f),
                            horizontalArrangement =
                                Arrangement.spacedBy(
                                    0.dp,
                                    Alignment.End,
                                ),
                            maxItemsInEachRow = 5,
                        ) {
                            styles.forEach { s ->
                                key("s_${s.name}_$index") {
                                    TextButton(
                                        text = s.name,
                                        isSelected = s == value.style.value,
                                        onClick = { value.style.value = s },
                                    )
                                }
                            }
                        }
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
            Image(
                modifier =
                    Modifier
                        .requiredSize(42.dp)
                        .padding(
                            Theme.spacing.space8,
                        ),
                imageVector = Question,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                colorFilter =
                    androidx.compose.ui.graphics.ColorFilter
                        .tint(Theme.color.neutral1),
            )

            Text(
                modifier =
                    Modifier
                        .weight(1f)
                        .padding(top = Theme.spacing.space8),
                text = localisation.theme.fontResource,
                style = Theme.typography.body,
                color = Theme.color.neutral1,
            )

            PrimaryIconButton(
                modifier =
                    Modifier
                        .padding(
                            Theme.spacing.space8,
                        ),
                icon = Trash2,
                onClick = {
                    state.values.clear()
                },
            )
        }
    }
}

@Composable
fun rememberFontFamilyConfiguratorState(): FontFamilyConfiguratorState = remember { FontFamilyConfiguratorState() }

class FontFamilyConfiguratorState {
    val values = mutableStateListOf<FontFamilyConfiguratorData>()

    fun add(fontFamilyConfiguratorData: FontFamilyConfiguratorData) {
        values.add(fontFamilyConfiguratorData)
    }

    fun remove(index: Int) {
        values.removeAt(index)
    }

    operator fun set(
        index: Int,
        fontFamilyConfiguratorData: FontFamilyConfiguratorData,
    ) {
        values[index] = fontFamilyConfiguratorData
    }
}

data class FontFamilyConfiguratorData(
    val name: MutableState<String> = mutableStateOf(""),
    val weight: MutableState<FontWeightAttribute> = mutableStateOf(FontWeightAttribute.W100),
    val style: MutableState<FontStyleAttribute> = mutableStateOf(FontStyleAttribute.NORMAL),
)

enum class FontWeightAttribute {
    W100,
    W200,
    W300,
    W400,
    W500,
    W600,
    W700,
    W800,
    W900,
}

enum class FontStyleAttribute {
    NORMAL,
    ITALIC,
}
