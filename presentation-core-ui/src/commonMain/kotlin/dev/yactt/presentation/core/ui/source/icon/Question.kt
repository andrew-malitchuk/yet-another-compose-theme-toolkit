package dev.yactt.presentation.core.ui.source.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Question: ImageVector
    get() {
        if (_Question != null) {
            return _Question!!
        }
        _Question =
            ImageVector
                .Builder(
                    name = "Question",
                    defaultWidth = 32.dp,
                    defaultHeight = 32.dp,
                    viewportWidth = 256f,
                    viewportHeight = 256f,
                ).apply {
                    path(fill = SolidColor(Color(0xFF000000))) {
                        moveTo(140f, 180f)
                        arcToRelative(12f, 12f, 0f, isMoreThanHalf = true, isPositiveArc = true, -12f, -12f)
                        arcTo(12f, 12f, 0f, isMoreThanHalf = false, isPositiveArc = true, 140f, 180f)
                        close()
                        moveTo(128f, 72f)
                        curveToRelative(-22.06f, 0f, -40f, 16.15f, -40f, 36f)
                        verticalLineToRelative(4f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, 0f)
                        verticalLineToRelative(-4f)
                        curveToRelative(0f, -11f, 10.77f, -20f, 24f, -20f)
                        reflectiveCurveToRelative(24f, 9f, 24f, 20f)
                        reflectiveCurveToRelative(-10.77f, 20f, -24f, 20f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -8f, 8f)
                        verticalLineToRelative(8f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, 0f)
                        verticalLineToRelative(-0.72f)
                        curveToRelative(18.24f, -3.35f, 32f, -17.9f, 32f, -35.28f)
                        curveTo(168f, 88.15f, 150.06f, 72f, 128f, 72f)
                        close()
                        moveTo(232f, 128f)
                        arcTo(104f, 104f, 0f, isMoreThanHalf = true, isPositiveArc = true, 128f, 24f)
                        arcTo(104.11f, 104.11f, 0f, isMoreThanHalf = false, isPositiveArc = true, 232f, 128f)
                        close()
                        moveTo(216f, 128f)
                        arcToRelative(88f, 88f, 0f, isMoreThanHalf = true, isPositiveArc = false, -88f, 88f)
                        arcTo(88.1f, 88.1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 216f, 128f)
                        close()
                    }
                }.build()

        return _Question!!
    }

@Suppress("ObjectPropertyName")
private var _Question: ImageVector? = null
