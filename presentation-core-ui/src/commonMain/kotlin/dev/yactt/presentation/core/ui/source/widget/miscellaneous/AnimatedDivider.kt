package dev.yactt.presentation.core.ui.source.widget.miscellaneous

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.yactt.presentation.core.styling.core.Theme

@Composable
fun AnimatedDivider(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
) {
    AnimatedVisibility(
        modifier = modifier,
        visible = isVisible,
    ) {
        Divider(
            modifier =
                Modifier
                    .fillMaxWidth(),
            thickness = 1.dp,
            color = Theme.color.neutral2,
        )
    }
}
