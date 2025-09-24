package dev.yactt.presentation.feature.home.core.components.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.source.icon.Gear
import dev.yactt.presentation.core.ui.source.widget.button.icon.secondary.SecondaryIconButton
import dev.yactt.presentation.core.ui.source.widget.field.InputField
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.AnimatedDivider

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    isDividerVisible: Boolean,
    packageName: MutableState<String>,
    onActionClick: (HomeHeaderAction) -> Unit,
) {
    val localisation = LocalLocalisation.current

    Column(modifier = modifier.fillMaxWidth().wrapContentHeight()) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(Theme.color.neutral0)
                    .padding(Theme.spacing.space8),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SecondaryIconButton(
                modifier =
                    Modifier
                        .padding(Theme.spacing.space8),
                icon = Gear,
                onClick = {
                    onActionClick(HomeHeaderAction.GoToSettings)
                },
            )
            InputField(
                value = packageName.value,
                onValueChange = { newValue ->
                    packageName.value = newValue
                },
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(Theme.spacing.space8),
                placeholder = {
                    Text(
                        text = localisation.home.packageName,
                        style = Theme.typography.button,
                        color = Theme.color.neutral1,
                    )
                },
                isError = false,
                singleLine = true,
                maxLines = 1,
                textStyle = Theme.typography.button,
                keyboardOptions = KeyboardOptions.Default,
                keyboardActions = KeyboardActions.Default,
                visualTransformation = SpaceToDotTransformation,
            )
        }
        AnimatedDivider(
            isVisible = isDividerVisible,
        )
    }
}

sealed interface HomeHeaderAction {
    data object GoToSettings : HomeHeaderAction
}

object SpaceToDotTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        // 1:1 mapping (each space rendered as a '.'); caret stays sane.
        val shown =
            buildString(text.length) {
                for (c in text.text) append(if (c.isWhitespace()) '.' else c)
            }
        val mapping =
            object : OffsetMapping {
                override fun originalToTransformed(offset: Int) = offset

                override fun transformedToOriginal(offset: Int) = offset
            }
        return TransformedText(AnnotatedString(shown), mapping)
    }
}
