package dev.yactt.presentation.feature.onboarding.core.components.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val OutlineIcon1: ImageVector
    get() {
        if (_IconName != null) {
            return _IconName!!
        }
        _IconName =
            ImageVector
                .Builder(
                    name = "IconName",
                    defaultWidth = 200.dp,
                    defaultHeight = 200.dp,
                    viewportWidth = 466.6648f,
                    viewportHeight = 466.6648f,
                ).apply {
                    path(
                        stroke = SolidColor(Color(0xFF4285F4)),
                        strokeLineWidth = 1f,
                    ) {
                        moveToRelative(230.258f, 2.003f)
                        curveToRelative(-8.25f, 0.087f, -16.474f, 2.312f, -23.824f, 6.662f)
                        lineTo(48.334f, 101.866f)
                        curveToRelative(-7.6f, 4.5f, -13.201f, 10.9f, -16.801f, 18.4f)
                        curveToRelative(-3.3f, 7f, -5f, 14.899f, -4.9f, 23.199f)
                        verticalLineToRelative(192.9f)
                        curveToRelative(0.1f, 11.3f, 6.2f, 21.699f, 16.1f, 27.299f)
                        lineToRelative(167.9f, 94.801f)
                        curveToRelative(7.4f, 4.2f, 15.7f, 6.199f, 23.9f, 6.199f)
                        verticalLineToRelative(-0.1f)
                        curveToRelative(8.3f, -0.1f, 16.5f, -2.3f, 23.9f, -6.6f)
                        lineToRelative(158.1f, -93.301f)
                        curveToRelative(14.7f, -8.7f, 23.7f, -24.5f, 23.5f, -41.6f)
                        verticalLineToRelative(-183.5f)
                        curveToRelative(-0.1f, -8.883f, -3.09f, -17.366f, -8.072f, -24.656f)
                        lineToRelative(0.072f, -0.043f)
                        curveToRelative(-4.6f, -6.7f, -10.8f, -12.4f, -17.9f, -16.4f)
                        lineTo(254.232f, 8.165f)
                        curveToRelative(-7.45f, -4.2f, -15.725f, -6.25f, -23.975f, -6.162f)
                        close()
                    }
                }.build()

        return _IconName!!
    }

@Suppress("ObjectPropertyName")
private var _IconName: ImageVector? = null
