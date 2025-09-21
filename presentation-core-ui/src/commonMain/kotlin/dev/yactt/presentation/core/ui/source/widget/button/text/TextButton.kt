package dev.yactt.presentation.core.ui.source.widget.button.text

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import dev.yactt.presentation.core.ui.source.widget.button.core.ButtonAnimation
import dev.yactt.presentation.core.ui.source.widget.button.core.ButtonColors
import dev.yactt.presentation.core.ui.source.widget.button.core.ButtonDefaults
import dev.yactt.presentation.core.ui.source.widget.button.core.ButtonSizes
import dev.yactt.presentation.core.ui.source.widget.button.core.StateButton

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    isSelected: Boolean = false,
    textStyle: TextStyle = ButtonDefaults.textStyle,
    colors: ButtonColors = ButtonDefaults.colors,
    sizes: ButtonSizes = ButtonDefaults.sizes,
    animation: ButtonAnimation = ButtonDefaults.animation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    StateButton(
        text,
        onClick,
        colors,
        sizes,
        textStyle,
        animation,
        modifier,
        enabled,
        isSelected,
        interactionSource,
    )
}
