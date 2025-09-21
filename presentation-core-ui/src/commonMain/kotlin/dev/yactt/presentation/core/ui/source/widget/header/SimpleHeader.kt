package dev.yactt.presentation.core.ui.source.widget.header

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.source.icon.ArrowLeft
import dev.yactt.presentation.core.ui.source.widget.button.icon.primary.PrimaryIconButton
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.AnimatedDivider

@Composable
fun SimpleHeader(
    modifier: Modifier = Modifier,
    title: String,
    isDividerVisible: Boolean,
    onNavClick: () -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth().wrapContentHeight()) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(Theme.color.neutral0),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PrimaryIconButton(
                modifier =
                    Modifier
                        .padding(Theme.spacing.space8),
                icon = ArrowLeft,
                onClick = onNavClick,
            )
            Text(
                text = title,
                modifier =
                    Modifier
                        .weight(1f)
                        .basicMarquee(),
                style = Theme.typography.headline,
                color = Theme.color.neutral2,
            )
        }
        AnimatedDivider(
            isVisible = isDividerVisible,
        )
    }
}
