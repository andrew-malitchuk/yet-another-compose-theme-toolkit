package dev.yactt.presentation.core.ui.source.widget.button.core

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import dev.yactt.presentation.core.ui.source.widget.item.core.ItemInteractionState

@Composable
fun StateButton(
    text: String,
    onClick: () -> Unit,
    colors: ButtonColors,
    sizes: ButtonSizes,
    textStyle: TextStyle,
    animation: ButtonAnimation,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isSelected: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isPressed by interactionSource.collectIsPressedAsState()
    val isFocused by interactionSource.collectIsFocusedAsState()

    var interactionState = 0
    if (isHovered) interactionState = interactionState.or(ButtonInteractionState.HOVER)
    if (isPressed) interactionState = interactionState.or(ButtonInteractionState.PRESSED)
    if (isFocused) interactionState = interactionState.or(ButtonInteractionState.FOCUSED)
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

    val foregroundColor = colors.foregroundColor(interactionState, enabled).value
    val borderColor = colors.borderColor(interactionState, enabled).value

    AnimateButton(
        text = text,
        foregroundColor = foregroundColor,
        borderColor = borderColor,
        minWidth = sizes.minWidth,
        minHeight = sizes.minHeight,
        paddings = sizes.contentPadding,
        animationDuration = animation.duration,
        animationEasing = animation.easing,
        textStyle = textStyle,
        modifier = currentModifier,
    )
}
