package dev.yactt.presentation.core.ui.source.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val TextAa: ImageVector
    get() {
        if (_TextAa != null) {
            return _TextAa!!
        }
        _TextAa =
            ImageVector
                .Builder(
                    name = "TextAa",
                    defaultWidth = 32.dp,
                    defaultHeight = 32.dp,
                    viewportWidth = 256f,
                    viewportHeight = 256f,
                ).apply {
                    path(fill = SolidColor(Color(0xFF000000))) {
                        moveTo(87.24f, 52.59f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -14.48f, 0f)
                        lineToRelative(-64f, 136f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = true, isPositiveArc = false, 14.48f, 6.81f)
                        lineTo(39.9f, 160f)
                        horizontalLineToRelative(80.2f)
                        lineToRelative(16.66f, 35.4f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = true, isPositiveArc = false, 14.48f, -6.81f)
                        close()
                        moveTo(47.43f, 144f)
                        lineTo(80f, 74.79f)
                        lineTo(112.57f, 144f)
                        close()
                        moveTo(200f, 96f)
                        curveToRelative(-12.76f, 0f, -22.73f, 3.47f, -29.63f, 10.32f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 11.26f, 11.36f)
                        curveToRelative(3.8f, -3.77f, 10f, -5.68f, 18.37f, -5.68f)
                        curveToRelative(13.23f, 0f, 24f, 9f, 24f, 20f)
                        verticalLineToRelative(3.22f)
                        arcTo(42.76f, 42.76f, 0f, isMoreThanHalf = false, isPositiveArc = false, 200f, 128f)
                        curveToRelative(-22.06f, 0f, -40f, 16.15f, -40f, 36f)
                        reflectiveCurveToRelative(17.94f, 36f, 40f, 36f)
                        arcToRelative(42.73f, 42.73f, 0f, isMoreThanHalf = false, isPositiveArc = false, 24f, -7.25f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, -0.75f)
                        lineTo(240f, 132f)
                        curveTo(240f, 112.15f, 222.06f, 96f, 200f, 96f)
                        close()
                        moveTo(200f, 184f)
                        curveToRelative(-13.23f, 0f, -24f, -9f, -24f, -20f)
                        reflectiveCurveToRelative(10.77f, -20f, 24f, -20f)
                        reflectiveCurveToRelative(24f, 9f, 24f, 20f)
                        reflectiveCurveTo(213.23f, 184f, 200f, 184f)
                        close()
                    }
                }.build()

        return _TextAa!!
    }

@Suppress("ObjectPropertyName")
private var _TextAa: ImageVector? = null
