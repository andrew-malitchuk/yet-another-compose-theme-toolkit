package dev.yactt.presentation.core.ui.source.widget.item.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import dev.yactt.presentation.core.ui.core.ext.has

interface ItemColors {
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

data class ItemColor(
    val disabledColor: Color = Color.Transparent,
    val focusedColor: Color = Color.Transparent,
    val hoveredColor: Color = Color.Transparent,
    val pressedColor: Color = Color.Transparent,
    val defaultColor: Color = Color.Transparent,
)

data class ItemColorConfigure(
    val borderColor: ItemColor = ItemColor(),
    val foregroundColor: ItemColor = ItemColor(),
    val backgroundColor: ItemColor = ItemColor(),
) {
    fun getItemColors(): ItemColors =
        object : ItemColors {
            @Composable
            override fun borderColor(
                interactionState: Int,
                enabled: Boolean,
            ): State<Color> =
                rememberUpdatedState(
                    when {
                        !enabled -> borderColor.disabledColor
                        interactionState has ItemInteractionState.HOVER -> borderColor.hoveredColor
                        interactionState has ItemInteractionState.PRESSED -> borderColor.pressedColor
                        interactionState has ItemInteractionState.SELECTED -> borderColor.pressedColor
                        else -> borderColor.defaultColor
                    },
                )

            @Composable
            override fun foregroundColor(
                interactionState: Int,
                enabled: Boolean,
            ): State<Color> =
                rememberUpdatedState(
                    when {
                        !enabled -> foregroundColor.disabledColor
                        interactionState has ItemInteractionState.HOVER -> foregroundColor.hoveredColor
                        interactionState has ItemInteractionState.PRESSED -> foregroundColor.pressedColor
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
                        interactionState has ItemInteractionState.PRESSED -> backgroundColor.pressedColor
                        interactionState has ItemInteractionState.HOVER -> backgroundColor.hoveredColor
                        else -> backgroundColor.defaultColor
                    },
                )
        }
}
