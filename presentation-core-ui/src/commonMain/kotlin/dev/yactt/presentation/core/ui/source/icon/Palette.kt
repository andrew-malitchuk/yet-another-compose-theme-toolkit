package dev.yactt.presentation.core.ui.source.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Palette: ImageVector
    get() {
        if (_Palette != null) {
            return _Palette!!
        }
        _Palette =
            ImageVector
                .Builder(
                    name = "Palette",
                    defaultWidth = 32.dp,
                    defaultHeight = 32.dp,
                    viewportWidth = 256f,
                    viewportHeight = 256f,
                ).apply {
                    path(fill = SolidColor(Color(0xFF000000))) {
                        moveTo(200.77f, 53.89f)
                        arcTo(103.27f, 103.27f, 0f, isMoreThanHalf = false, isPositiveArc = false, 128f, 24f)
                        horizontalLineToRelative(-1.07f)
                        arcTo(104f, 104f, 0f, isMoreThanHalf = false, isPositiveArc = false, 24f, 128f)
                        curveToRelative(0f, 43f, 26.58f, 79.06f, 69.36f, 94.17f)
                        arcTo(32f, 32f, 0f, isMoreThanHalf = false, isPositiveArc = false, 136f, 192f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = true, 16f, -16f)
                        horizontalLineToRelative(46.21f)
                        arcToRelative(31.81f, 31.81f, 0f, isMoreThanHalf = false, isPositiveArc = false, 31.2f, -24.88f)
                        arcToRelative(104.43f, 104.43f, 0f, isMoreThanHalf = false, isPositiveArc = false, 2.59f, -24f)
                        arcTo(103.28f, 103.28f, 0f, isMoreThanHalf = false, isPositiveArc = false, 200.77f, 53.89f)
                        close()
                        moveTo(213.77f, 147.6f)
                        arcTo(15.89f, 15.89f, 0f, isMoreThanHalf = false, isPositiveArc = true, 198.21f, 160f)
                        lineTo(152f, 160f)
                        arcToRelative(32f, 32f, 0f, isMoreThanHalf = false, isPositiveArc = false, -32f, 32f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = true, -21.31f, 15.07f)
                        curveTo(62.49f, 194.3f, 40f, 164f, 40f, 128f)
                        arcToRelative(88f, 88f, 0f, isMoreThanHalf = false, isPositiveArc = true, 87.09f, -88f)
                        horizontalLineToRelative(0.9f)
                        arcToRelative(88.35f, 88.35f, 0f, isMoreThanHalf = false, isPositiveArc = true, 88f, 87.25f)
                        arcTo(88.86f, 88.86f, 0f, isMoreThanHalf = false, isPositiveArc = true, 213.81f, 147.6f)
                        close()
                        moveTo(140f, 76f)
                        arcToRelative(12f, 12f, 0f, isMoreThanHalf = true, isPositiveArc = true, -12f, -12f)
                        arcTo(12f, 12f, 0f, isMoreThanHalf = false, isPositiveArc = true, 140f, 76f)
                        close()
                        moveTo(96f, 100f)
                        arcTo(12f, 12f, 0f, isMoreThanHalf = true, isPositiveArc = true, 84f, 88f)
                        arcTo(12f, 12f, 0f, isMoreThanHalf = false, isPositiveArc = true, 96f, 100f)
                        close()
                        moveTo(96f, 156f)
                        arcToRelative(12f, 12f, 0f, isMoreThanHalf = true, isPositiveArc = true, -12f, -12f)
                        arcTo(12f, 12f, 0f, isMoreThanHalf = false, isPositiveArc = true, 96f, 156f)
                        close()
                        moveTo(184f, 100f)
                        arcToRelative(12f, 12f, 0f, isMoreThanHalf = true, isPositiveArc = true, -12f, -12f)
                        arcTo(12f, 12f, 0f, isMoreThanHalf = false, isPositiveArc = true, 184f, 100f)
                        close()
                    }
                }.build()

        return _Palette!!
    }

@Suppress("ObjectPropertyName")
private var _Palette: ImageVector? = null
