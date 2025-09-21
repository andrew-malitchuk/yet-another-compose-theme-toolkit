package dev.yactt.presentation.core.ui.source.widget.item.core

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

@Composable
fun AnimateItem(
    icon: ImageVector?,
    text: String,
    backgroundColor: Color,
    foregroundColor: Color,
    borderColor: Color,
    shape: Shape,
    iconSize: Dp,
    borderSize: Dp,
    minWidth: Dp,
    minHeight: Dp,
    paddings: PaddingValues,
    animationDuration: Int,
    animationEasing: Easing,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
) {
    val colorAnimationSpec =
        tween<Color>(durationMillis = animationDuration, easing = animationEasing)
    val animatedBorderColor by animateColorAsState(
        animationSpec = colorAnimationSpec,
        targetValue = borderColor,
        label = "border",
    )
    val animatedBackgroundColor by animateColorAsState(
        animationSpec = colorAnimationSpec,
        targetValue = backgroundColor,
        label = "background",
    )
    val animatedForegroundColor by animateColorAsState(
        animationSpec = colorAnimationSpec,
        targetValue = foregroundColor,
        label = "foreground",
    )

    val localModifier =
        modifier.animateContentSize(
            animationSpec =
                tween(
                    durationMillis = animationDuration,
                    easing = animationEasing,
                ),
        )
    DrawItem(
        icon = icon,
        text = text,
        backgroundColor = animatedBackgroundColor,
        foregroundColor = animatedForegroundColor,
        borderColor = animatedBorderColor,
        shape = shape,
        iconSize = iconSize,
        borderSize = borderSize,
        minWidth = minWidth,
        minHeight = minHeight,
        paddings = paddings,
        modifier = localModifier,
        textStyle = textStyle,
    )
}
