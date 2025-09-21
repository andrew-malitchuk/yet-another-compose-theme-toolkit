package dev.yactt.presentation.core.ui.source.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Gear: ImageVector
    get() {
        if (_Gear != null) {
            return _Gear!!
        }
        _Gear =
            ImageVector
                .Builder(
                    name = "Gear",
                    defaultWidth = 32.dp,
                    defaultHeight = 32.dp,
                    viewportWidth = 256f,
                    viewportHeight = 256f,
                ).apply {
                    path(fill = SolidColor(Color(0xFF000000))) {
                        moveTo(128f, 80f)
                        arcToRelative(48f, 48f, 0f, isMoreThanHalf = true, isPositiveArc = false, 48f, 48f)
                        arcTo(48.05f, 48.05f, 0f, isMoreThanHalf = false, isPositiveArc = false, 128f, 80f)
                        close()
                        moveTo(128f, 160f)
                        arcToRelative(32f, 32f, 0f, isMoreThanHalf = true, isPositiveArc = true, 32f, -32f)
                        arcTo(32f, 32f, 0f, isMoreThanHalf = false, isPositiveArc = true, 128f, 160f)
                        close()
                        moveTo(216f, 130.16f)
                        quadToRelative(0.06f, -2.16f, 0f, -4.32f)
                        lineToRelative(14.92f, -18.64f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.48f, -7.06f)
                        arcToRelative(107.21f, 107.21f, 0f, isMoreThanHalf = false, isPositiveArc = false, -10.88f, -26.25f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -6f, -3.93f)
                        lineToRelative(-23.72f, -2.64f)
                        quadToRelative(-1.48f, -1.56f, -3f, -3f)
                        lineTo(186f, 40.54f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.94f, -6f)
                        arcToRelative(107.71f, 107.71f, 0f, isMoreThanHalf = false, isPositiveArc = false, -26.25f, -10.87f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -7.06f, 1.49f)
                        lineTo(130.16f, 40f)
                        quadTo(128f, 40f, 125.84f, 40f)
                        lineTo(107.2f, 25.11f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -7.06f, -1.48f)
                        arcTo(107.6f, 107.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, 73.89f, 34.51f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.93f, 6f)
                        lineTo(67.32f, 64.27f)
                        quadToRelative(-1.56f, 1.49f, -3f, 3f)
                        lineTo(40.54f, 70f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -6f, 3.94f)
                        arcToRelative(107.71f, 107.71f, 0f, isMoreThanHalf = false, isPositiveArc = false, -10.87f, 26.25f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.49f, 7.06f)
                        lineTo(40f, 125.84f)
                        quadTo(40f, 128f, 40f, 130.16f)
                        lineTo(25.11f, 148.8f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.48f, 7.06f)
                        arcToRelative(107.21f, 107.21f, 0f, isMoreThanHalf = false, isPositiveArc = false, 10.88f, 26.25f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 6f, 3.93f)
                        lineToRelative(23.72f, 2.64f)
                        quadToRelative(1.49f, 1.56f, 3f, 3f)
                        lineTo(70f, 215.46f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.94f, 6f)
                        arcToRelative(107.71f, 107.71f, 0f, isMoreThanHalf = false, isPositiveArc = false, 26.25f, 10.87f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 7.06f, -1.49f)
                        lineTo(125.84f, 216f)
                        quadToRelative(2.16f, 0.06f, 4.32f, 0f)
                        lineToRelative(18.64f, 14.92f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 7.06f, 1.48f)
                        arcToRelative(107.21f, 107.21f, 0f, isMoreThanHalf = false, isPositiveArc = false, 26.25f, -10.88f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.93f, -6f)
                        lineToRelative(2.64f, -23.72f)
                        quadToRelative(1.56f, -1.48f, 3f, -3f)
                        lineTo(215.46f, 186f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 6f, -3.94f)
                        arcToRelative(107.71f, 107.71f, 0f, isMoreThanHalf = false, isPositiveArc = false, 10.87f, -26.25f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.49f, -7.06f)
                        close()
                        moveTo(199.9f, 123.66f)
                        arcToRelative(73.93f, 73.93f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 8.68f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.74f, 5.48f)
                        lineToRelative(14.19f, 17.73f)
                        arcToRelative(91.57f, 91.57f, 0f, isMoreThanHalf = false, isPositiveArc = true, -6.23f, 15f)
                        lineTo(187f, 173.11f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -5.1f, 2.64f)
                        arcToRelative(74.11f, 74.11f, 0f, isMoreThanHalf = false, isPositiveArc = true, -6.14f, 6.14f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -2.64f, 5.1f)
                        lineToRelative(-2.51f, 22.58f)
                        arcToRelative(91.32f, 91.32f, 0f, isMoreThanHalf = false, isPositiveArc = true, -15f, 6.23f)
                        lineToRelative(-17.74f, -14.19f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -5f, -1.75f)
                        horizontalLineToRelative(-0.48f)
                        arcToRelative(73.93f, 73.93f, 0f, isMoreThanHalf = false, isPositiveArc = true, -8.68f, 0f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -5.48f, 1.74f)
                        lineTo(100.45f, 215.8f)
                        arcToRelative(91.57f, 91.57f, 0f, isMoreThanHalf = false, isPositiveArc = true, -15f, -6.23f)
                        lineTo(82.89f, 187f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -2.64f, -5.1f)
                        arcToRelative(74.11f, 74.11f, 0f, isMoreThanHalf = false, isPositiveArc = true, -6.14f, -6.14f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -5.1f, -2.64f)
                        lineTo(46.43f, 170.6f)
                        arcToRelative(91.32f, 91.32f, 0f, isMoreThanHalf = false, isPositiveArc = true, -6.23f, -15f)
                        lineToRelative(14.19f, -17.74f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.74f, -5.48f)
                        arcToRelative(73.93f, 73.93f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, -8.68f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.74f, -5.48f)
                        lineTo(40.2f, 100.45f)
                        arcToRelative(91.57f, 91.57f, 0f, isMoreThanHalf = false, isPositiveArc = true, 6.23f, -15f)
                        lineTo(69f, 82.89f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5.1f, -2.64f)
                        arcToRelative(74.11f, 74.11f, 0f, isMoreThanHalf = false, isPositiveArc = true, 6.14f, -6.14f)
                        arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 82.89f, 69f)
                        lineTo(85.4f, 46.43f)
                        arcToRelative(91.32f, 91.32f, 0f, isMoreThanHalf = false, isPositiveArc = true, 15f, -6.23f)
                        lineToRelative(17.74f, 14.19f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5.48f, 1.74f)
                        arcToRelative(73.93f, 73.93f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8.68f, 0f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5.48f, -1.74f)
                        lineTo(155.55f, 40.2f)
                        arcToRelative(91.57f, 91.57f, 0f, isMoreThanHalf = false, isPositiveArc = true, 15f, 6.23f)
                        lineTo(173.11f, 69f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 2.64f, 5.1f)
                        arcToRelative(74.11f, 74.11f, 0f, isMoreThanHalf = false, isPositiveArc = true, 6.14f, 6.14f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5.1f, 2.64f)
                        lineToRelative(22.58f, 2.51f)
                        arcToRelative(91.32f, 91.32f, 0f, isMoreThanHalf = false, isPositiveArc = true, 6.23f, 15f)
                        lineToRelative(-14.19f, 17.74f)
                        arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 199.87f, 123.66f)
                        close()
                    }
                }.build()

        return _Gear!!
    }

@Suppress("ObjectPropertyName")
private var _Gear: ImageVector? = null
