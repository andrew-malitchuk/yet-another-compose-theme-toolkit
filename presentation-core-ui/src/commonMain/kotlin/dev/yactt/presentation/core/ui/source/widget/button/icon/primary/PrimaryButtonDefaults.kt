package dev.yactt.presentation.core.ui.source.widget.button.icon.primary

import androidx.compose.animation.core.EaseInCirc
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.source.widget.button.core.ButtonAnimationConfigure
import dev.yactt.presentation.core.ui.source.widget.button.core.ButtonColor
import dev.yactt.presentation.core.ui.source.widget.button.core.ButtonColorConfigure
import dev.yactt.presentation.core.ui.source.widget.button.core.ButtonSizeConfigure

object PrimaryButtonDefaults {
    val colors
        @Composable
        get() =
            ButtonColorConfigure(
                foregroundColor =
                    ButtonColor(
                        disabledColor = Theme.color.neutral2,
                        focusedColor = Theme.color.accent0,
                        hoveredColor = Theme.color.accent0,
                        pressedColor = Theme.color.accent1,
                        defaultColor = Theme.color.neutral1,
                    ),
                backgroundColor =
                    ButtonColor(
                        disabledColor = Color.Transparent,
                        focusedColor = Theme.color.neutral1,
                        hoveredColor = Theme.color.neutral1,
                        pressedColor = Theme.color.neutral1,
                        defaultColor = Color.Transparent,
                    ),
            ).getButtonColors()

    val sizes =
        ButtonSizeConfigure(
            iconSize = 24.dp,
            borderSize = 0.dp,
            contentPadding = PaddingValues(8.dp),
            minWidth = 32.dp,
            minHeight = 32.dp,
        ).getButtonSize()

    val animation =
        ButtonAnimationConfigure(
            duration = 300,
            easing = EaseInCirc,
        ).getButtonAnimation()

    val shape = CircleShape
}
