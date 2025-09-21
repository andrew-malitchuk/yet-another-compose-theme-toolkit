package dev.yactt.presentation.core.ui.source.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Package: ImageVector
    get() {
        if (_Package != null) {
            return _Package!!
        }
        _Package =
            ImageVector
                .Builder(
                    name = "Package",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                ).apply {
                    path(
                        stroke = SolidColor(Color(0xFF000000)),
                        strokeLineWidth = 2f,
                        strokeLineCap = StrokeCap.Round,
                        strokeLineJoin = StrokeJoin.Round,
                    ) {
                        moveTo(16.5f, 9.4f)
                        lineTo(7.5f, 4.21f)
                    }
                    path(
                        stroke = SolidColor(Color(0xFF000000)),
                        strokeLineWidth = 2f,
                        strokeLineCap = StrokeCap.Round,
                        strokeLineJoin = StrokeJoin.Round,
                    ) {
                        moveTo(21f, 16f)
                        verticalLineTo(8f)
                        arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, -1.73f)
                        lineToRelative(-7f, -4f)
                        arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = false, -2f, 0f)
                        lineToRelative(-7f, 4f)
                        arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3f, 8f)
                        verticalLineToRelative(8f)
                        arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 1.73f)
                        lineToRelative(7f, 4f)
                        arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = false, 2f, 0f)
                        lineToRelative(7f, -4f)
                        arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = false, 21f, 16f)
                        close()
                    }
                    path(
                        stroke = SolidColor(Color(0xFF000000)),
                        strokeLineWidth = 2f,
                        strokeLineCap = StrokeCap.Round,
                        strokeLineJoin = StrokeJoin.Round,
                    ) {
                        moveTo(3.27f, 6.96f)
                        lineToRelative(8.73f, 5.05f)
                        lineToRelative(8.73f, -5.05f)
                    }
                    path(
                        stroke = SolidColor(Color(0xFF000000)),
                        strokeLineWidth = 2f,
                        strokeLineCap = StrokeCap.Round,
                        strokeLineJoin = StrokeJoin.Round,
                    ) {
                        moveTo(12f, 22.08f)
                        lineTo(12f, 12f)
                    }
                }.build()

        return _Package!!
    }

@Suppress("ObjectPropertyName")
private var _Package: ImageVector? = null
