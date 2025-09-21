package dev.yactt.presentation.core.ui.source.widget.button.core

import androidx.compose.animation.core.Easing
import androidx.compose.runtime.Immutable

@Immutable
interface ButtonAnimation {
    val duration: Int
    val easing: Easing
}

data class ButtonAnimationConfigure(
    val duration: Int,
    val easing: Easing,
) {
    fun getButtonAnimation(): ButtonAnimation =
        object : ButtonAnimation {
            override val duration: Int = this@ButtonAnimationConfigure.duration
            override val easing: Easing = this@ButtonAnimationConfigure.easing
        }
}
