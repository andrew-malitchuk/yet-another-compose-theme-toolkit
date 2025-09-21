package dev.yactt.presentation.core.ui.source.widget.item.primary

import androidx.compose.animation.core.EaseInCirc
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.source.widget.item.core.ItemAnimationConfigure
import dev.yactt.presentation.core.ui.source.widget.item.core.ItemColor
import dev.yactt.presentation.core.ui.source.widget.item.core.ItemColorConfigure
import dev.yactt.presentation.core.ui.source.widget.item.core.ItemSizeConfigure

object PrimaryItemDefaults {
    val colors
        @Composable
        get() =
            ItemColorConfigure(
                foregroundColor =
                    ItemColor(
                        disabledColor = Theme.color.neutral1,
                        focusedColor = Theme.color.neutral1,
                        hoveredColor = Theme.color.neutral1,
                        pressedColor = Theme.color.accent2,
                        defaultColor = Theme.color.neutral1,
                    ),
                borderColor =
                    ItemColor(
                        disabledColor = Theme.color.neutral1,
                        focusedColor = Theme.color.accent1,
                        hoveredColor = Theme.color.accent1,
                        pressedColor = Theme.color.accent0,
                        defaultColor = Color.Transparent,
                    ),
            ).getItemColors()

    val sizes
        @Composable
        get() =
            ItemSizeConfigure(
                iconSize = 24.dp,
                borderSize = 0.dp,
                contentPadding =
                    PaddingValues(
                        Theme.spacing.space16,
                        Theme.spacing.space8,
                    ),
                minWidth = 32.dp,
                minHeight = 32.dp,
            ).getItemSize()

    val animation =
        ItemAnimationConfigure(
            duration = 300,
            easing = EaseInCirc,
        ).getItemAnimation()

    val textStyle: TextStyle
        @Composable
        get() = Theme.typography.button

    val shape = CircleShape
}
