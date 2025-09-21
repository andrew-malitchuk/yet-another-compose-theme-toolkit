package dev.yactt.presentation.core.ui.source.widget.button.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import dev.yactt.presentation.core.ui.core.ext.has
import dev.yactt.presentation.core.ui.source.widget.item.core.ItemInteractionState

interface ButtonColors {
    @Stable
    @Composable
    fun borderColor(
        interactionState: Int,
        enabled: Boolean,
    ): State<Color>

    @Stable
    @Composable
    fun foregroundColor(
        interactionState: Int,
        enabled: Boolean,
    ): State<Color>

    @Stable
    @Composable
    fun backgroundColor(
        interactionState: Int,
        enabled: Boolean,
    ): State<Color>
}

data class ButtonColor(
    val disabledColor: Color = Color.Transparent,
    val focusedColor: Color = Color.Transparent,
    val hoveredColor: Color = Color.Transparent,
    val pressedColor: Color = Color.Transparent,
    val defaultColor: Color = Color.Transparent,
)

data class ButtonColorConfigure(
    val borderColor: ButtonColor = ButtonColor(),
    val foregroundColor: ButtonColor = ButtonColor(),
    val backgroundColor: ButtonColor = ButtonColor(),
) {
    fun getButtonColors(): ButtonColors =
        object : ButtonColors {
            @Composable
            override fun borderColor(
                interactionState: Int,
                enabled: Boolean,
            ): State<Color> =
                remember(interactionState, enabled, borderColor) {
                    derivedStateOf {
                        when {
                            !enabled -> borderColor.disabledColor
                            // if you want a special border for selected, put it early:
                            (interactionState has ItemInteractionState.SELECTED) -> borderColor.focusedColor // or a dedicated 'selected' color if you add one
                            (interactionState has ButtonInteractionState.PRESSED) -> borderColor.pressedColor
                            (interactionState has ButtonInteractionState.HOVER) -> borderColor.hoveredColor
                            (interactionState has ButtonInteractionState.FOCUSED) -> borderColor.focusedColor
                            else -> borderColor.defaultColor
                        }
                    }
                }

            @Composable
            override fun foregroundColor(
                interactionState: Int,
                enabled: Boolean,
            ): State<Color> =
                rememberUpdatedState(
                    when {
                        !enabled -> foregroundColor.disabledColor
                        interactionState has ButtonInteractionState.HOVER -> foregroundColor.hoveredColor
                        interactionState has ButtonInteractionState.PRESSED -> foregroundColor.pressedColor
                        else -> foregroundColor.defaultColor
                    },
                )

            @Composable
            override fun backgroundColor(
                interactionState: Int,
                enabled: Boolean,
            ): State<Color> =
                rememberUpdatedState(
                    when {
                        !enabled -> backgroundColor.disabledColor
                        interactionState has ButtonInteractionState.PRESSED -> backgroundColor.pressedColor
                        interactionState has ButtonInteractionState.HOVER -> backgroundColor.hoveredColor
                        else -> backgroundColor.defaultColor
                    },
                )
        }
}
