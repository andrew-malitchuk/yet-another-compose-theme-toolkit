package dev.yactt.presentation.feature.splash.core.components.widget

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.feature.onboarding.core.components.icon.OutlineIcon1
import dev.yactt.presentation.feature.onboarding.core.components.icon.OutlineIcon2
import dev.yactt.presentation.feature.onboarding.core.components.icon.OutlineIcon3
import dev.yactt.presentation.feature.onboarding.core.components.icon.OutlineIcon4
import kotlinx.coroutines.delay

@Composable
fun SplashLoading() {
    var animState by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(100)

            animState += 1

            delay(6_000)
        }
    }
    var visible by remember { mutableStateOf(true) }

    val animAlpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 2500, easing = FastOutSlowInEasing),
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(100)
            visible = !visible
            delay(3_000)
            // Toggle visibility
        }
    }

    val animRotationZ2 by animateFloatAsState(
        targetValue = animState * 360f,
        animationSpec =
            tween(
                durationMillis = 5_000,
                delayMillis = 800,
                easing = FastOutSlowInEasing,
            ),
    )

    val animRotationZ3 by animateFloatAsState(
        targetValue = animState * 360f,
        animationSpec =
            tween(
                durationMillis = 5_000,
                delayMillis = 900,
                easing = FastOutSlowInEasing,
            ),
    )

    val animRotationZ4 by animateFloatAsState(
        targetValue = animState * 360f,
        animationSpec =
            tween(
                durationMillis = 5_000,
                delayMillis = 1000,
                easing = FastOutSlowInEasing,
            ),
    )

    val animRotationZ5 by animateFloatAsState(
        targetValue = animState * 360f,
        animationSpec =
            tween(
                durationMillis = 5_000,
                delayMillis = 1100,
                easing = FastOutSlowInEasing,
            ),
    )

    Box(
        Modifier
            .wrapContentSize(),
    ) {
        Box(
            modifier =
                Modifier
                    .wrapContentSize()
                    .requiredWidth((8 * 16 * 5).dp),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                modifier =
                    Modifier
                        .size((8 * 16).dp)
                        .alpha(animAlpha),
                imageVector = dev.yactt.presentation.core.ui.source.icon.Cube,
                contentDescription = "Jetpack Compose Outline Logo",
                contentScale = ContentScale.Fit,
                colorFilter =
                    androidx.compose.ui.graphics.ColorFilter
                        .tint(Theme.color.primary0),
            )

            Image(
                modifier =
                    Modifier
                        .graphicsLayer {
                            rotationZ = animRotationZ2
                        }.requiredSize((8 * 16 * 2).dp)
                        .padding(Theme.spacing.space8)
                        .alpha(1f),
                imageVector = OutlineIcon4,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                colorFilter =
                    androidx.compose.ui.graphics.ColorFilter
                        .tint(Theme.color.neutral1),
            )

            Image(
                modifier =
                    Modifier
                        .graphicsLayer {
                            rotationZ = animRotationZ3
                        }.requiredSize((8 * 16 * 3).dp)
                        .padding(Theme.spacing.space8)
                        .alpha(.7f),
                imageVector = OutlineIcon3,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                colorFilter =
                    androidx.compose.ui.graphics.ColorFilter
                        .tint(Theme.color.neutral1),
            )

            Image(
                modifier =
                    Modifier
                        .graphicsLayer {
                            rotationZ = animRotationZ4
                        }.requiredSize((8 * 16 * 4).dp)
                        .padding(Theme.spacing.space8)
                        .alpha(.4f),
                imageVector = OutlineIcon2,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                colorFilter =
                    androidx.compose.ui.graphics.ColorFilter
                        .tint(Theme.color.neutral1),
            )

            Image(
                modifier =
                    Modifier
                        .requiredSize((8 * 16 * 5).dp)
                        .padding(Theme.spacing.space8)
                        .alpha(.1f)
                        .graphicsLayer {
                            rotationZ = animRotationZ5
                        },
                imageVector = OutlineIcon1,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                colorFilter =
                    androidx.compose.ui.graphics.ColorFilter
                        .tint(Theme.color.neutral1),
            )
        }
    }
}
