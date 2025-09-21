package dev.yactt.presentation.core.ui.source.widget.button.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DrawButton(
    text: String,
    foregroundColor: Color,
    borderColor: Color,
    minWidth: Dp,
    minHeight: Dp,
    paddings: PaddingValues,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier =
            modifier
                .padding(paddings)
                .defaultMinSize(minWidth = minWidth, minHeight = minHeight),
    ) {
        Text(text = text, color = foregroundColor, style = textStyle)

        Divider(
            modifier =
                Modifier
                    .align(Alignment.BottomCenter)
                    .height(4.dp)
                    .width(minWidth)
                    .padding(horizontal = 2.dp)
                    .clip(CircleShape),
            color = borderColor,
        )
    }
}
