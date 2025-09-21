package dev.yactt.presentation.core.ui.source.widget.button.core

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

@Composable
fun AnimateButton(
    text: String,
    foregroundColor: Color,
    borderColor: Color,
    minWidth: Dp,
    minHeight: Dp,
    paddings: PaddingValues,
    textStyle: TextStyle,
    animationDuration: Int,
    animationEasing: Easing,
    modifier: Modifier = Modifier,
) {
    val colorAnimationSpec =
        tween<Color>(durationMillis = animationDuration, easing = animationEasing)
    val animatedForegroundColor by animateColorAsState(
        animationSpec = colorAnimationSpec,
        targetValue = foregroundColor,
        label = "foreground",
    )
    val animatedBorderColor by animateColorAsState(
        animationSpec = colorAnimationSpec,
        targetValue = borderColor,
        label = "border",
    )

    val localModifier =
        modifier.animateContentSize(
            animationSpec =
                tween(
                    durationMillis = animationDuration,
                    easing = animationEasing,
                ),
        )
    DrawButton(
        text = text,
        foregroundColor = animatedForegroundColor,
        borderColor = animatedBorderColor,
        minWidth = minWidth,
        minHeight = minHeight,
        paddings = paddings,
        modifier = localModifier,
        textStyle = textStyle,
    )
}
