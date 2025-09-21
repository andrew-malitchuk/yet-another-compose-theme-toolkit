package dev.yactt.presentation.core.ui.source.widget.item

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import dev.yactt.presentation.core.styling.core.Theme

@Composable
fun SettingsItem(
    modifier: Modifier = Modifier,
    title: String,
    content: (@Composable () -> Unit)? = null,
) {
    Row(
        modifier =
            modifier
                .height(Theme.size.size48)
                .padding(
                    horizontal = Theme.spacing.space8,
                ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            modifier =
                Modifier
                    .weight(1f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = Theme.typography.body,
            color = Theme.color.neutral2,
        )
        content?.let {
            Box(
                modifier =
                    Modifier
                        .padding(start = Theme.spacing.space8),
                contentAlignment = Alignment.Center,
            ) {
                it()
            }
        }
    }
}
