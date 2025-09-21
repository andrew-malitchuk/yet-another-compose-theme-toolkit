package dev.yactt.presentation.core.ui.source.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FloppyDisk: ImageVector
    get() {
        if (_FloppyDisk != null) {
            return _FloppyDisk!!
        }
        _FloppyDisk =
            ImageVector
                .Builder(
                    name = "FloppyDisk",
                    defaultWidth = 32.dp,
                    defaultHeight = 32.dp,
                    viewportWidth = 256f,
                    viewportHeight = 256f,
                ).apply {
                    path(fill = SolidColor(Color(0xFF000000))) {
                        moveTo(219.31f, 72f)
                        lineTo(184f, 36.69f)
                        arcTo(15.86f, 15.86f, 0f, isMoreThanHalf = false, isPositiveArc = false, 172.69f, 32f)
                        lineTo(48f, 32f)
                        arcTo(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 32f, 48f)
                        lineTo(32f, 208f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, 16f)
                        lineTo(208f, 224f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, -16f)
                        lineTo(224f, 83.31f)
                        arcTo(15.86f, 15.86f, 0f, isMoreThanHalf = false, isPositiveArc = false, 219.31f, 72f)
                        close()
                        moveTo(168f, 208f)
                        lineTo(88f, 208f)
                        lineTo(88f, 152f)
                        horizontalLineToRelative(80f)
                        close()
                        moveTo(208f, 208f)
                        lineTo(184f, 208f)
                        lineTo(184f, 152f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, -16f, -16f)
                        lineTo(88f, 136f)
                        arcToRelative(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, -16f, 16f)
                        verticalLineToRelative(56f)
                        lineTo(48f, 208f)
                        lineTo(48f, 48f)
                        lineTo(172.69f, 48f)
                        lineTo(208f, 83.31f)
                        close()
                        moveTo(160f, 72f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, -8f, 8f)
                        lineTo(96f, 80f)
                        arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, -16f)
                        horizontalLineToRelative(56f)
                        arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 160f, 72f)
                        close()
                    }
                }.build()

        return _FloppyDisk!!
    }

@Suppress("ObjectPropertyName")
private var _FloppyDisk: ImageVector? = null
