package dev.yactt.presentation.core.ui.source.widget.item.core

import androidx.compose.animation.core.EaseInCirc
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import dev.yactt.presentation.core.styling.core.Theme

object ItemDefaults {
    val colors
        @Composable
        get() =
            ItemColorConfigure(
                borderColor =
                    ItemColor(),
                foregroundColor =
                    ItemColor(
                        disabledColor = Theme.color.neutral1,
                        focusedColor = Theme.color.neutral1,
                        hoveredColor = Theme.color.neutral1,
                        pressedColor = Theme.color.neutral1,
                        defaultColor = Theme.color.neutral2,
                    ),
                backgroundColor =
                    ItemColor(),
            ).getItemColors()

    val sizes =
        ItemSizeConfigure(
            iconSize = 32.dp,
            borderSize = 0.dp,
            contentPadding = PaddingValues(8.dp),
            minWidth = 48.dp,
            minHeight = 48.dp,
        ).getItemSize()

    val animation =
        ItemAnimationConfigure(
            duration = 300,
            easing = EaseInCirc,
        ).getItemAnimation()

    val textStyle: TextStyle
        @Composable
        get() = Theme.typography.button
}
