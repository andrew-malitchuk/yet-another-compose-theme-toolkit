package dev.yactt.domain.core.source.model

enum class ThemeEntity constructor(
    val isDark: Boolean,
) {
    LIGHT(false),
    DARK(true),
}

fun ThemeEntity.isDark(): Boolean = this.isDark
