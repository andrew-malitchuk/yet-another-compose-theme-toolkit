package dev.yactt.presentation.core.ui.source.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Ruler: ImageVector
    get() {
        if (_Ruler != null) {
            return _Ruler!!
        }
        _Ruler =
            ImageVector
                .Builder(
                    name = "Ruler",
                    defaultWidth = 32.dp,
                    defaultHeight = 32.dp,
                    viewportWidth = 256f,
                    viewportHeight = 256f,
                ).apply {
                    path(fill = SolidColor(Color(0xFF000000))) {
                        moveTo(235.32f, 73.37f)
                        lineTo(182.63f, 20.69f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, -22.63f, 0f)
                        lineTo(20.68f, 160f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 22.63f)
                        lineToRelative(52.69f, 52.68f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 22.63f, 0f)
                        lineTo(235.32f, 96f)
                        arcTo(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 235.32f, 73.37f)
                        close()
                        moveTo(84.68f, 224f)
                        lineTo(32f, 171.31f)
                        lineToRelative(32f, -32f)
                        lineToRelative(26.34f, 26.35f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 11.32f, -11.32f)
                        lineTo(75.31f, 128f)
                        lineTo(96f, 107.31f)
                        lineToRelative(26.34f, 26.35f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 11.32f, -11.32f)
                        lineTo(107.31f, 96f)
                        lineTo(128f, 75.31f)
                        lineToRelative(26.34f, 26.35f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 11.32f, -11.32f)
                        lineTo(139.31f, 64f)
                        lineToRelative(32f, -32f)
                        lineTo(224f, 84.69f)
                        close()
                    }
                }.build()

        return _Ruler!!
    }

@Suppress("ObjectPropertyName")
private var _Ruler: ImageVector? = null
