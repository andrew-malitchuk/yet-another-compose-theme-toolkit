package dev.yactt.presentation.core.ui.source.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Backspace: ImageVector
    get() {
        if (_Backspace != null) {
            return _Backspace!!
        }
        _Backspace =
            ImageVector
                .Builder(
                    name = "Backspace",
                    defaultWidth = 32.dp,
                    defaultHeight = 32.dp,
                    viewportWidth = 256f,
                    viewportHeight = 256f,
                ).apply {
                    path(fill = SolidColor(Color(0xFF000000))) {
                        moveTo(216f, 40f)
                        horizontalLineTo(68.53f)
                        arcToRelative(16.08f, 16.08f, 0f, isMoreThanHalf = false, isPositiveArc = false, -13.72f, 7.77f)
                        lineTo(9.14f, 123.88f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 8.24f)
                        lineToRelative(45.67f, 76.11f)
                        arcTo(16.08f, 16.08f, 0f, isMoreThanHalf = false, isPositiveArc = false, 68.53f, 216f)
                        horizontalLineTo(216f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, -16f)
                        verticalLineTo(56f)
                        arcTo(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 216f, 40f)
                        close()
                        moveTo(61.67f, 204.12f)
                        lineTo(68.53f, 200f)
                        horizontalLineToRelative(0f)
                        close()
                        moveTo(216f, 200f)
                        horizontalLineTo(68.53f)
                        lineToRelative(-43.2f, -72f)
                        lineToRelative(43.2f, -72f)
                        horizontalLineTo(216f)
                        close()
                        moveTo(106.34f, 146.34f)
                        lineTo(124.69f, 128f)
                        lineToRelative(-18.35f, -18.34f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 11.32f, -11.32f)
                        lineTo(136f, 116.69f)
                        lineToRelative(18.34f, -18.35f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 11.32f, 11.32f)
                        lineTo(147.31f, 128f)
                        lineToRelative(18.35f, 18.34f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, -11.32f, 11.32f)
                        lineTo(136f, 139.31f)
                        lineToRelative(-18.34f, 18.35f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, -11.32f, -11.32f)
                        close()
                    }
                }.build()

        return _Backspace!!
    }

@Suppress("ObjectPropertyName")
private var _Backspace: ImageVector? = null
