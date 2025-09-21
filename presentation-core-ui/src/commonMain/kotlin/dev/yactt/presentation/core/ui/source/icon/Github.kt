package dev.yactt.presentation.core.ui.source.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Github: ImageVector
    get() {
        if (_Github != null) {
            return _Github!!
        }
        _Github =
            ImageVector
                .Builder(
                    name = "Github",
                    defaultWidth = 32.dp,
                    defaultHeight = 32.dp,
                    viewportWidth = 256f,
                    viewportHeight = 256f,
                ).apply {
                    path(fill = SolidColor(Color(0xFF000000))) {
                        moveTo(208.31f, 75.68f)
                        arcTo(59.78f, 59.78f, 0f, isMoreThanHalf = false, isPositiveArc = false, 202.93f, 28f)
                        arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 196f, 24f)
                        arcToRelative(59.75f, 59.75f, 0f, isMoreThanHalf = false, isPositiveArc = false, -48f, 24f)
                        horizontalLineTo(124f)
                        arcTo(59.75f, 59.75f, 0f, isMoreThanHalf = false, isPositiveArc = false, 76f, 24f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -6.93f, 4f)
                        arcToRelative(59.78f, 59.78f, 0f, isMoreThanHalf = false, isPositiveArc = false, -5.38f, 47.68f)
                        arcTo(58.14f, 58.14f, 0f, isMoreThanHalf = false, isPositiveArc = false, 56f, 104f)
                        verticalLineToRelative(8f)
                        arcToRelative(56.06f, 56.06f, 0f, isMoreThanHalf = false, isPositiveArc = false, 48.44f, 55.47f)
                        arcTo(39.8f, 39.8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 96f, 192f)
                        verticalLineToRelative(8f)
                        horizontalLineTo(72f)
                        arcToRelative(24f, 24f, 0f, isMoreThanHalf = false, isPositiveArc = true, -24f, -24f)
                        arcTo(40f, 40f, 0f, isMoreThanHalf = false, isPositiveArc = false, 8f, 136f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 16f)
                        arcToRelative(24f, 24f, 0f, isMoreThanHalf = false, isPositiveArc = true, 24f, 24f)
                        arcToRelative(40f, 40f, 0f, isMoreThanHalf = false, isPositiveArc = false, 40f, 40f)
                        horizontalLineTo(96f)
                        verticalLineToRelative(16f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, 0f)
                        verticalLineTo(192f)
                        arcToRelative(24f, 24f, 0f, isMoreThanHalf = false, isPositiveArc = true, 48f, 0f)
                        verticalLineToRelative(40f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, 0f)
                        verticalLineTo(192f)
                        arcToRelative(39.8f, 39.8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -8.44f, -24.53f)
                        arcTo(56.06f, 56.06f, 0f, isMoreThanHalf = false, isPositiveArc = false, 216f, 112f)
                        verticalLineToRelative(-8f)
                        arcTo(58.14f, 58.14f, 0f, isMoreThanHalf = false, isPositiveArc = false, 208.31f, 75.68f)
                        close()
                        moveTo(200f, 112f)
                        arcToRelative(40f, 40f, 0f, isMoreThanHalf = false, isPositiveArc = true, -40f, 40f)
                        horizontalLineTo(112f)
                        arcToRelative(40f, 40f, 0f, isMoreThanHalf = false, isPositiveArc = true, -40f, -40f)
                        verticalLineToRelative(-8f)
                        arcToRelative(41.74f, 41.74f, 0f, isMoreThanHalf = false, isPositiveArc = true, 6.9f, -22.48f)
                        arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 80f, 73.83f)
                        arcToRelative(43.81f, 43.81f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.79f, -33.58f)
                        arcToRelative(43.88f, 43.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, 32.32f, 20.06f)
                        arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 119.82f, 64f)
                        horizontalLineToRelative(32.35f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 6.74f, -3.69f)
                        arcToRelative(43.87f, 43.87f, 0f, isMoreThanHalf = false, isPositiveArc = true, 32.32f, -20.06f)
                        arcTo(43.81f, 43.81f, 0f, isMoreThanHalf = false, isPositiveArc = true, 192f, 73.83f)
                        arcToRelative(8.09f, 8.09f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 7.65f)
                        arcTo(41.72f, 41.72f, 0f, isMoreThanHalf = false, isPositiveArc = true, 200f, 104f)
                        close()
                    }
                }.build()

        return _Github!!
    }

@Suppress("ObjectPropertyName")
private var _Github: ImageVector? = null
