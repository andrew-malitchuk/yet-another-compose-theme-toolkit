package dev.yactt.presentation.core.ui.source.layout

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitDragOrCancellation
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.unit.dp
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.core.util.window.WindowSizeHelper

@Composable
fun AdaptiveContainer(
    modifier: Modifier = Modifier,
    compactContent: @Composable (Modifier) -> Unit,
    primaryContent: (@Composable (Modifier) -> Unit)? = null,
    secondaryContent: @Composable (Modifier) -> Unit,
) {
    var leftPanelWeight by remember { mutableStateOf(0.3f) }
    var isExpanded by remember { mutableStateOf(false) }

    val baseHeight = Theme.spacing.space64
    val expandedHeight = baseHeight * 2

    val animatedHeight by animateDpAsState(
        targetValue = if (isExpanded) expandedHeight else baseHeight,
        animationSpec = tween(durationMillis = 200),
        label = "divider-height",
    )

    when (WindowSizeHelper.shouldUseExpandedLayout()) {
        true -> {
            Row(modifier = Modifier.fillMaxSize().statusBarsPadding()) {
                Box(
                    modifier =
                        Modifier
                            .weight(leftPanelWeight)
                            .fillMaxHeight()
                            .background(Theme.color.neutral0),
                    contentAlignment = Alignment.Center,
                ) {
                    if (primaryContent != null) {
                        primaryContent(Modifier)
                    } else {
                        compactContent(Modifier)
                    }
                }

                Box(
                    modifier =
                        Modifier
                            .width(Theme.spacing.space16) // Width of the draggable divider
                            .fillMaxHeight()
                            .background(Theme.color.neutral0)
                            .pointerInput(Unit) {
                                awaitPointerEventScope {
                                    while (true) {
                                        val down = awaitFirstDown()
                                        isExpanded = true

                                        var pointerId = down.id
                                        var dragAmountX = 0f

                                        // Drag loop
                                        var event = awaitDragOrCancellation(pointerId)
                                        while (event != null) {
                                            val dragX = event.positionChange().x
                                            dragAmountX += dragX

                                            val sensitivityFactor = 0.01f
                                            leftPanelWeight =
                                                (leftPanelWeight + (dragX / size.width) * sensitivityFactor)
                                                    .coerceIn(0.2f, 0.8f)

                                            event.consume()
                                            event = awaitDragOrCancellation(pointerId)
                                        }

                                        isExpanded = false
                                    }
                                }
                            },
                    contentAlignment = Alignment.Center,
                ) {
                    Box(
                        modifier =
                            Modifier
                                .width(Theme.spacing.space16)
                                .height(animatedHeight)
                                .padding(2.dp)
                                .clip(CircleShape)
                                .background(Theme.color.primary0),
                    )
                }

                Box(
                    modifier =
                        Modifier
                            .weight(1f - leftPanelWeight)
                            .fillMaxHeight()
                            .background(Theme.color.neutral0),
                    contentAlignment = Alignment.Center,
                ) {
                    secondaryContent(Modifier)
                }
            }
        }

        else -> {
            Box(
                modifier =
                    modifier
                        .fillMaxSize()
                        .background(Theme.color.neutral0),
            ) {
                compactContent(Modifier.fillMaxSize())
            }
        }
    }
}
