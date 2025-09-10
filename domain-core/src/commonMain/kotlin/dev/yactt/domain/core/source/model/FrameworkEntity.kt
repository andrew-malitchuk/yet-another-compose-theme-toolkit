package dev.yactt.domain.core.source.model

enum class FrameworkEntity constructor(
    val platform: String,
) {
    CMP("CMP"),
    NATIVE("Native"),
}

fun FrameworkEntity.isNative() = this == FrameworkEntity.NATIVE
