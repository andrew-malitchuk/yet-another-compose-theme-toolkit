package dev.yactt.presentation.core.ui.source.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EyedropperSample: ImageVector
    get() {
        if (_EyedropperSample != null) {
            return _EyedropperSample!!
        }
        _EyedropperSample =
            ImageVector
                .Builder(
                    name = "EyedropperSample",
                    defaultWidth = 32.dp,
                    defaultHeight = 32.dp,
                    viewportWidth = 256f,
                    viewportHeight = 256f,
                ).apply {
                    path(fill = SolidColor(Color(0xFF000000))) {
                        moveTo(224f, 67.3f)
                        arcToRelative(35.79f, 35.79f, 0f, isMoreThanHalf = false, isPositiveArc = false, -11.26f, -25.66f)
                        curveToRelative(-14f, -13.28f, -36.72f, -12.78f, -50.62f, 1.13f)
                        lineTo(142.8f, 62.2f)
                        arcToRelative(24f, 24f, 0f, isMoreThanHalf = false, isPositiveArc = false, -33.14f, 0.77f)
                        lineToRelative(-9f, 9f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 22.64f)
                        lineToRelative(2f, 2.06f)
                        lineToRelative(-51f, 51f)
                        arcToRelative(39.75f, 39.75f, 0f, isMoreThanHalf = false, isPositiveArc = false, -10.53f, 38f)
                        lineToRelative(-8f, 18.41f)
                        arcTo(13.65f, 13.65f, 0f, isMoreThanHalf = false, isPositiveArc = false, 36f, 219.29f)
                        arcToRelative(15.9f, 15.9f, 0f, isMoreThanHalf = false, isPositiveArc = false, 17.71f, 3.36f)
                        lineTo(71.24f, 215f)
                        arcToRelative(39.9f, 39.9f, 0f, isMoreThanHalf = false, isPositiveArc = false, 37.05f, -10.75f)
                        lineToRelative(51f, -51f)
                        lineToRelative(2.06f, 2.06f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 22.62f, 0f)
                        lineToRelative(9f, -9f)
                        arcToRelative(24f, 24f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.74f, -33.18f)
                        lineToRelative(19.75f, -19.87f)
                        arcTo(35.75f, 35.75f, 0f, isMoreThanHalf = false, isPositiveArc = false, 224f, 67.3f)
                        close()
                        moveTo(97f, 193f)
                        arcToRelative(24f, 24f, 0f, isMoreThanHalf = false, isPositiveArc = true, -24f, 6f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -5.55f, 0.31f)
                        lineToRelative(-18.1f, 7.9f)
                        lineTo(57f, 189.41f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.25f, -5.75f)
                        arcToRelative(24f, 24f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.1f, -15.69f)
                        lineTo(122f, 167.97f)
                        close()
                        moveTo(138f, 152f)
                        lineTo(70.07f, 152f)
                        lineToRelative(44f, -44f)
                        lineToRelative(33.94f, 34f)
                        close()
                        moveTo(202.18f, 82f)
                        lineTo(176.81f, 107.52f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 11.31f)
                        lineToRelative(4.89f, 4.88f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 11.32f)
                        lineToRelative(-9f, 9f)
                        lineTo(112f, 83.26f)
                        lineToRelative(9f, -9f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 11.31f, 0f)
                        lineToRelative(4.89f, 4.89f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5.65f, 2.34f)
                        horizontalLineToRelative(0f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5.66f, -2.36f)
                        lineToRelative(24.94f, -25.09f)
                        curveToRelative(7.81f, -7.82f, 20.5f, -8.18f, 28.29f, -0.81f)
                        arcToRelative(20f, 20f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.39f, 28.7f)
                        close()
                    }
                }.build()

        return _EyedropperSample!!
    }

@Suppress("ObjectPropertyName")
private var _EyedropperSample: ImageVector? = null
