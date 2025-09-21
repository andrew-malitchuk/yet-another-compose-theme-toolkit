package dev.yactt.presentation.core.ui.source.widget.item.primary

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import dev.yactt.presentation.core.ui.source.widget.item.core.ItemAnimation
import dev.yactt.presentation.core.ui.source.widget.item.core.ItemColors
import dev.yactt.presentation.core.ui.source.widget.item.core.ItemSizes
import dev.yactt.presentation.core.ui.source.widget.item.core.StateItem

@Composable
fun PrimaryItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    text: String,
    enabled: Boolean = true,
    isSelected: Boolean = true,
    textStyle: TextStyle = PrimaryItemDefaults.textStyle,
    shape: Shape = PrimaryItemDefaults.shape,
    colors: ItemColors = PrimaryItemDefaults.colors,
    sizes: ItemSizes = PrimaryItemDefaults.sizes,
    animation: ItemAnimation = PrimaryItemDefaults.animation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    StateItem(
        onClick,
        icon,
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
