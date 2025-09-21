package dev.yactt.presentation.core.ui.source.widget.item.core

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

@Immutable
interface ItemSizes {
    val iconSize: Dp
    val borderSize: Dp
    val contentPadding: PaddingValues
    val minWidth: Dp
    val minHeight: Dp
}

data class ItemSizeConfigure(
    val iconSize: Dp,
    val borderSize: Dp,
    val contentPadding: PaddingValues,
    val minWidth: Dp,
    val minHeight: Dp,
) {
    fun getItemSize(): ItemSizes =
        object : ItemSizes {
            override val iconSize: Dp = this@ItemSizeConfigure.iconSize
            override val borderSize: Dp = this@ItemSizeConfigure.borderSize
            override val contentPadding: PaddingValues = this@ItemSizeConfigure.contentPadding
            override val minWidth: Dp = this@ItemSizeConfigure.minWidth
            override val minHeight: Dp = this@ItemSizeConfigure.minHeight
        }
}
