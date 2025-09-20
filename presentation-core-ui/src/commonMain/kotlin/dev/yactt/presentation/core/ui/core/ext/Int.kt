package dev.yactt.presentation.core.ui.core.ext

infix fun Int.has(bit: Int) = this.and(bit) != 0
