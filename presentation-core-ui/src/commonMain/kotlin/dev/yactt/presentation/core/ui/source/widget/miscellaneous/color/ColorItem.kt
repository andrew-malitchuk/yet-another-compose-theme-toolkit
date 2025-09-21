package dev.yactt.presentation.core.ui.source.widget.miscellaneous.color

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.yactt.presentation.core.styling.core.Theme

@Composable
fun ColorItem(
    modifier: Modifier = Modifier,
    color: Color,
) {
    Box(
        modifier =
            modifier
                .clip(RoundedCornerShape(Theme.size.size8))
                .border(1.dp, Theme.color.neutral1, RoundedCornerShape(Theme.size.size8))
                .background(color),
    )
}
