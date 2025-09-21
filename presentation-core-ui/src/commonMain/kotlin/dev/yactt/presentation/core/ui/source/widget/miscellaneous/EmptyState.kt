package dev.yactt.presentation.core.ui.source.widget.miscellaneous

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.core.ext.makeScrollable
import dev.yactt.presentation.core.ui.source.icon.Gear
import dev.yactt.presentation.core.ui.source.widget.button.icon.primary.PrimaryIconButton

@Composable
fun EmptyState(
    modifier: Modifier = Modifier,
    title: String,
    description: String? = null,
    onAction: () -> Unit,
    action: ImageVector? = null,
) {
    Box(
        modifier =
            modifier
                .fillMaxSize()
                .makeScrollable(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier =
                Modifier
                    .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier =
                    Modifier
                        .fillMaxWidth(),
                text = title,
                maxLines = 2,
                minLines = 1,
                textAlign = TextAlign.Center,
                style = Theme.typography.title,
                color = Theme.color.neutral2,
            )
            description?.let {
                Spacer(modifier = Modifier.height(Theme.spacing.space8))
                Text(
                    modifier =
                        Modifier
                            .fillMaxWidth(),
                    text = it,
                    maxLines = 2,
                    minLines = 1,
                    textAlign = TextAlign.Center,
                    style = Theme.typography.body,
                    color = Theme.color.neutral1,
                )
            }
            action?.let {
                Spacer(modifier = Modifier.height(Theme.spacing.space16))
                PrimaryIconButton(
                    modifier = Modifier,
                    icon = Gear,
                    onClick = onAction,
                )
            }
        }
    }
}
