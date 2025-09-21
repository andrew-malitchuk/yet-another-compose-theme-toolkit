package dev.yactt.presentation.core.ui.source.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Cube: ImageVector
    get() {
        if (_Cube != null) {
            return _Cube!!
        }
        _Cube =
            ImageVector
                .Builder(
                    name = "Cube",
                    defaultWidth = 32.dp,
                    defaultHeight = 32.dp,
                    viewportWidth = 256f,
                    viewportHeight = 256f,
                ).apply {
                    path(fill = SolidColor(Color(0xFF000000))) {
                        moveTo(223.68f, 66.15f)
                        lineTo(135.68f, 18f)
                        horizontalLineToRelative(0f)
                        arcToRelative(15.88f, 15.88f, 0f, isMoreThanHalf = false, isPositiveArc = false, -15.36f, 0f)
                        lineToRelative(-88f, 48.17f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, -8.32f, 14f)
                        verticalLineToRelative(95.64f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 8.32f, 14f)
                        lineToRelative(88f, 48.17f)
                        arcToRelative(15.88f, 15.88f, 0f, isMoreThanHalf = false, isPositiveArc = false, 15.36f, 0f)
                        lineToRelative(88f, -48.17f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 8.32f, -14f)
                        lineTo(232f, 80.18f)
                        arcTo(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 223.68f, 66.15f)
                        close()
                        moveTo(128f, 32f)
                        horizontalLineToRelative(0f)
                        lineToRelative(80.34f, 44f)
                        lineTo(128f, 120f)
                        lineTo(47.66f, 76f)
                        close()
                        moveTo(40f, 90f)
                        lineToRelative(80f, 43.78f)
                        verticalLineToRelative(85.79f)
                        lineTo(40f, 175.82f)
                        close()
                        moveTo(136f, 219.57f)
                        lineTo(136f, 133.82f)
                        lineTo(216f, 90f)
                        verticalLineToRelative(85.78f)
                        close()
                    }
                }.build()

        return _Cube!!
    }

@Suppress("ObjectPropertyName")
private var _Cube: ImageVector? = null
