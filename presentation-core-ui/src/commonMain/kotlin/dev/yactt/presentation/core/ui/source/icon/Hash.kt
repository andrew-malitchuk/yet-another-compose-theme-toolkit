package dev.yactt.presentation.core.ui.source.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Hash: ImageVector
    get() {
        if (_Hash != null) {
            return _Hash!!
        }
        _Hash =
            ImageVector
                .Builder(
                    name = "Hash",
                    defaultWidth = 32.dp,
                    defaultHeight = 32.dp,
                    viewportWidth = 256f,
                    viewportHeight = 256f,
                ).apply {
                    path(fill = SolidColor(Color(0xFF000000))) {
                        moveTo(224f, 88f)
                        lineTo(175.4f, 88f)
                        lineToRelative(8.47f, -46.57f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -15.74f, -2.86f)
                        lineToRelative(-9f, 49.43f)
                        lineTo(111.4f, 88f)
                        lineToRelative(8.47f, -46.57f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -15.74f, -2.86f)
                        lineTo(95.14f, 88f)
                        lineTo(48f, 88f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 16f)
                        lineTo(92.23f, 104f)
                        lineTo(83.5f, 152f)
                        lineTo(32f, 152f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 16f)
                        lineTo(80.6f, 168f)
                        lineToRelative(-8.47f, 46.57f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 6.44f, 9.3f)
                        arcTo(7.79f, 7.79f, 0f, isMoreThanHalf = false, isPositiveArc = false, 80f, 224f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 7.86f, -6.57f)
                        lineToRelative(9f, -49.43f)
                        lineTo(144.6f, 168f)
                        lineToRelative(-8.47f, 46.57f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 6.44f, 9.3f)
                        arcTo(7.79f, 7.79f, 0f, isMoreThanHalf = false, isPositiveArc = false, 144f, 224f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 7.86f, -6.57f)
                        lineToRelative(9f, -49.43f)
                        lineTo(208f, 168f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, -16f)
                        lineTo(163.77f, 152f)
                        lineToRelative(8.73f, -48f)
                        lineTo(224f, 104f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, -16f)
                        close()
                        moveTo(147.5f, 152f)
                        lineTo(99.77f, 152f)
                        lineToRelative(8.73f, -48f)
                        horizontalLineToRelative(47.73f)
                        close()
                    }
                }.build()

        return _Hash!!
    }

@Suppress("ObjectPropertyName")
private var _Hash: ImageVector? = null
