package dev.yactt.presentation.core.ui.source.miscellaneous.colorpicker.helper

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import dev.yactt.presentation.core.ui.source.miscellaneous.colorpicker.data.ColorRange
import kotlin.math.pow
import kotlin.math.sqrt

internal object ColorPickerHelper {
    fun calculateRangeProgress(progress: Double): Pair<Double, ColorRange> {
        val range: ColorRange
        return progress * 6 -
            when {
                progress < 1f / 6 -> {
                    range = ColorRange.RedToYellow
                    0
                }

                progress < 2f / 6 -> {
                    range = ColorRange.YellowToGreen
                    1
                }

                progress < 3f / 6 -> {
                    range = ColorRange.GreenToCyan
                    2
                }

                progress < 4f / 6 -> {
                    range = ColorRange.CyanToBlue
                    3
                }

                progress < 5f / 6 -> {
                    range = ColorRange.BlueToPurple
                    4
                }

                else -> {
                    range = ColorRange.PurpleToRed
                    5
                }
            } to range
    }

    fun calculateInitialPickerLocation(
        initialColor: Color,
        colorPickerSize: IntSize,
        rangeColor: Color,
    ): Offset {
        val xProgress = calculateLightness(initialColor, rangeColor)
        val yProgress = calculateDarkness(initialColor)

        return Offset(
            x = colorPickerSize.width * xProgress,
            y = colorPickerSize.height * yProgress,
        )
    }

    private fun calculateLightness(
        initialColor: Color,
        rangeColor: Color,
    ): Float {
        val initialLuminance = (initialColor.red + initialColor.green + initialColor.blue) / 3
        val rangeLuminance = (rangeColor.red + rangeColor.green + rangeColor.blue) / 3

        return initialLuminance / rangeLuminance
    }

    private fun calculateDarkness(initialColor: Color): Float = 1f - initialColor.alpha

    fun Color.lightness(): Float = (red + green + blue) / 3f

    fun Color.darkness(): Float = 1f - lightness()

    fun calculateInitialProgress(
        initialColor: Color,
        colors: List<Color>,
    ): Float {
        if (colors.isEmpty() || colors.size == 1) return 0f

        var bestMatchIndex = 0
        var minDistance = Float.MAX_VALUE
        for (i in 0 until colors.size - 1) {
            val distance = colorDistance(initialColor, colors[i])
            if (distance < minDistance) {
                minDistance = distance
                bestMatchIndex = i
            }
        }

        val startColor = colors[bestMatchIndex]
        val endColor = colors[bestMatchIndex + 1]
        val rangeDistance = colorDistance(startColor, endColor)
        val progressWithinRange =
            (colorDistance(startColor, initialColor) / rangeDistance).coerceIn(0f, 1f)

        return (bestMatchIndex + progressWithinRange) / (colors.size - 1)
    }

    private fun colorDistance(
        color1: Color,
        color2: Color,
    ): Float =
        sqrt(
            (color1.red - color2.red).pow(2) +
                (color1.green - color2.green).pow(2) +
                (color1.blue - color2.blue).pow(2),
        )
}
