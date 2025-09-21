package dev.yactt.presentation.core.ui.source.widget.button.icon.primary

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import dev.yactt.presentation.core.ui.source.widget.button.core.ButtonAnimation
import dev.yactt.presentation.core.ui.source.widget.button.core.ButtonColors
import dev.yactt.presentation.core.ui.source.widget.button.core.ButtonSizes
import dev.yactt.presentation.core.ui.source.widget.button.text.core.StateButton

@Composable
fun PrimaryIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    enabled: Boolean = true,
    shape: Shape = PrimaryButtonDefaults.shape,
    colors: ButtonColors = PrimaryButtonDefaults.colors,
    sizes: ButtonSizes = PrimaryButtonDefaults.sizes,
    animation: ButtonAnimation = PrimaryButtonDefaults.animation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    StateButton(
        onClick,
        icon,
        colors,
        sizes,
        shape,
        animation,
        modifier,
        enabled,
        interactionSource,
    )
}
