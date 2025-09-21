package dev.yactt.presentation.core.ui.source.widget.item.core

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle

@Composable
fun StateItem(
    onClick: () -> Unit,
    icon: ImageVector?,
    text: String,
    colors: ItemColors,
    sizes: ItemSizes,
    textStyle: TextStyle,
    shape: Shape,
    animation: ItemAnimation,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isSelected: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isPressed by interactionSource.collectIsPressedAsState()
    val isFocused by interactionSource.collectIsFocusedAsState()

    var interactionState = 0
    if (isHovered) interactionState = interactionState.or(ItemInteractionState.HOVER)
    if (isPressed) interactionState = interactionState.or(ItemInteractionState.PRESSED)
    if (isFocused) interactionState = interactionState.or(ItemInteractionState.FOCUSED)
    if (isSelected) {
        interactionState = interactionState.or(ItemInteractionState.SELECTED)
    }

    val currentModifier =
        modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
            enabled = enabled,
            onClick = onClick,
            role = Role.Button,
        )

    val backgroundColor = colors.backgroundColor(interactionState, enabled).value
    val foregroundColor = colors.foregroundColor(interactionState, enabled).value
    val borderColor = colors.borderColor(interactionState, enabled).value

    AnimateItem(
        icon = icon,
        text = text,
        backgroundColor = backgroundColor,
        foregroundColor = foregroundColor,
        borderColor = borderColor,
        shape = shape,
        iconSize = sizes.iconSize,
        borderSize = sizes.borderSize,
        minWidth = sizes.minWidth,
        minHeight = sizes.minHeight,
        paddings = sizes.contentPadding,
        animationDuration = animation.duration,
        animationEasing = animation.easing,
        textStyle = textStyle,
        modifier = currentModifier,
    )
}
