package dev.yactt.presentation.core.ui.source.widget.button.core

import androidx.compose.animation.core.EaseInCirc
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import dev.yactt.presentation.core.styling.core.Theme

object ButtonDefaults {
    val colors
        @Composable
        get() =
            ButtonColorConfigure(
                borderColor =
                    ButtonColor(
                        disabledColor = Theme.color.neutral1,
                        focusedColor = Theme.color.accent1,
                        hoveredColor = Theme.color.accent1,
                        pressedColor = Theme.color.accent0,
                        defaultColor = Color.Transparent,
                    ),
                foregroundColor =
                    ButtonColor(
                        disabledColor = Theme.color.neutral1,
                        focusedColor = Theme.color.neutral1,
                        hoveredColor = Theme.color.neutral1,
                        pressedColor = Theme.color.neutral1,
                        defaultColor = Theme.color.neutral2,
                    ),
                backgroundColor =
                    ButtonColor(),
            ).getButtonColors()

    val sizes =
        ButtonSizeConfigure(
            iconSize = 32.dp,
            borderSize = 0.dp,
            contentPadding = PaddingValues(8.dp),
            minWidth = 48.dp,
            minHeight = 32.dp,
        ).getButtonSize()

    val animation =
        ButtonAnimationConfigure(
            duration = 300,
            easing = EaseInCirc,
        ).getButtonAnimation()

    val textStyle: TextStyle
        @Composable
        get() = Theme.typography.button
}
