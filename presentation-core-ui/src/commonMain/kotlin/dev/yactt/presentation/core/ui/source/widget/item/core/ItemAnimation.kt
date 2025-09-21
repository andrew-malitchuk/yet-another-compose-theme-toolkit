package dev.yactt.presentation.core.ui.source.widget.item.core

import androidx.compose.animation.core.Easing
import androidx.compose.runtime.Immutable

@Immutable
interface ItemAnimation {
    val duration: Int
    val easing: Easing
}

data class ItemAnimationConfigure(
    val duration: Int,
    val easing: Easing,
) {
    fun getItemAnimation(): ItemAnimation =
        object : ItemAnimation {
            override val duration: Int = this@ItemAnimationConfigure.duration
            override val easing: Easing = this@ItemAnimationConfigure.easing
        }
}
