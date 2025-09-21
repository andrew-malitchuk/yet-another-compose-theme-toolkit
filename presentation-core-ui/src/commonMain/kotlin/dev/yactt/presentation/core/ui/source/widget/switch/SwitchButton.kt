package dev.yactt.presentation.core.ui.source.widget.switch

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.yactt.presentation.core.styling.core.Theme

@Composable
fun SwitchButton(
    modifier: Modifier = Modifier,
    width: Dp = Theme.spacing.space48,
    height: Dp = Theme.spacing.space24,
    checkedTrackColor: Color = Theme.color.accent1,
    uncheckedTrackColor: Color = Theme.color.neutral1,
    gapBetweenThumbAndTrackEdge: Dp = 2.dp,
    iconInnerPadding: Dp = Theme.spacing.space8,
    thumbSize: Dp = Theme.spacing.space16,
    initValue: Boolean = false,
    onStateChange: ((Boolean) -> Unit)? = null,
    background: Color = Theme.color.neutral2,
    value: Boolean? = null,
) {
    val interactionSource =
        remember {
            MutableInteractionSource()
        }
    var onSideChangeState by remember {
        mutableStateOf(initValue)
    }

    if (value != null && value != onSideChangeState) {
        onSideChangeState = value
    }

    val alignment by animateAlignmentAsState(if (onSideChangeState) 1f else -1f)
    Box(
        modifier =
            modifier
                .size(width = width, height = height)
//            .border(
//                width = borderWidth,
//                color = if (onSideChangeState) checkedTrackColor else uncheckedTrackColor,
//                shape = RoundedCornerShape(percent = cornerSize),
//            )
                .background(
                    color = background,
                    shape = CircleShape,
                ).clickable(
                    indication = null,
                    interactionSource = interactionSource,
                ) {
                    onSideChangeState = onSideChangeState.not()
                    onStateChange?.invoke(onSideChangeState)
                },
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier =
                Modifier
                    .padding(
                        start = gapBetweenThumbAndTrackEdge,
                        end = gapBetweenThumbAndTrackEdge,
                    ).fillMaxSize(),
            contentAlignment = alignment,
        ) {
            Box(
                modifier =
                    Modifier
                        .size(size = thumbSize)
                        .background(
                            color = if (onSideChangeState) checkedTrackColor else uncheckedTrackColor,
                            shape = CircleShape,
                        ).padding(all = iconInnerPadding),
            )
        }
    }
}

@Composable
private fun animateAlignmentAsState(targetBiasValue: Float): State<BiasAlignment> {
    val bias by animateFloatAsState(targetBiasValue, label = "")
    return remember { derivedStateOf { BiasAlignment(horizontalBias = bias, verticalBias = 0f) } }
}
