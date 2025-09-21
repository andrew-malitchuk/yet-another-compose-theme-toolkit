package dev.yactt.presentation.core.ui.source.widget.button.text.core

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

@Immutable
interface ButtonSizes {
    val iconSize: Dp
    val borderSize: Dp
    val contentPadding: PaddingValues
    val minWidth: Dp
    val minHeight: Dp
}

data class ButtonSizeConfigure(
    val iconSize: Dp,
    val borderSize: Dp,
    val contentPadding: PaddingValues,
    val minWidth: Dp,
    val minHeight: Dp,
) {
    fun getButtonSize(): ButtonSizes =
        object : ButtonSizes {
            override val iconSize: Dp = this@ButtonSizeConfigure.iconSize
            override val borderSize: Dp = this@ButtonSizeConfigure.borderSize
            override val contentPadding: PaddingValues = this@ButtonSizeConfigure.contentPadding
            override val minWidth: Dp = this@ButtonSizeConfigure.minWidth
            override val minHeight: Dp = this@ButtonSizeConfigure.minHeight
        }
}
