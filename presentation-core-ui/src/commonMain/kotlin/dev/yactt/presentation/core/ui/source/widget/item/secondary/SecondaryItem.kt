package dev.yactt.presentation.core.ui.source.widget.item.secondary

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import dev.yactt.presentation.core.ui.source.widget.item.core.ItemAnimation
import dev.yactt.presentation.core.ui.source.widget.item.core.ItemColors
import dev.yactt.presentation.core.ui.source.widget.item.core.ItemSizes
import dev.yactt.presentation.core.ui.source.widget.item.core.StateItem

@Composable
fun SecondaryItem(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    isSelected: Boolean = true,
    textStyle: TextStyle = SecondaryItemDefaults.textStyle,
    shape: Shape = SecondaryItemDefaults.shape,
    colors: ItemColors = SecondaryItemDefaults.colors,
    sizes: ItemSizes = SecondaryItemDefaults.sizes,
    animation: ItemAnimation = SecondaryItemDefaults.animation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    StateItem(
        onClick = onClick,
        null,
        text,
        colors,
        sizes,
        textStyle,
        shape,
        animation,
        modifier,
        enabled,
        isSelected,
        interactionSource,
    )
}
