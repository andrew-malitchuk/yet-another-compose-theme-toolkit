package dev.yactt.presentation.core.platform.core.convertor.base

abstract class BaseArtifactConvertor<T>(
    open val packageName: String,
    open val className: String,
) {
    /**
     * Generate the artifact code based on the provided state.
     *
     * For example, data class for ThemeColor, ThemeFontSize, etc.
     */
    abstract fun generateArtifact(state: T): String

    /**
     * Generate the artifact implementation.
     *
     * For example,attributeDarkColorPalette, attributeFontSize, etc.
     */
    abstract fun generateAttribute(state: T): String

    /**
     * Generate the staticCompositionLocalOf code for the artifact.
     */
    abstract fun generateProvider(): String
}
