package dev.yactt.presentation.feature.theme.typography.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.source.widget.item.secondary.SecondaryItem
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.AnimatedDivider
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.EmptyState

/**
 * SizePicker shows a list of size options or an empty state if no options
 * are available.  The currently selected size is highlighted, and selecting
 * an option triggers the provided [onPick] callback.
 *
 * @param modifier   Modifier applied to the root container.
 * @param data       Containing the available sizes.
 * @param selected   Name of the size that is currently selected.
 * @param onPick     Callback invoked with the name of the selected size.
 * @param title      Title shown in the empty state.
 * @param icon       Optional icon displayed in the empty state.
 * @param description Description shown under the title in the empty state.
 */
@Composable
fun ValuePicker(
    modifier: Modifier = Modifier,
    data: List<String>,
    selected: String? = null,
    title: String,
    description: String,
    header: String,
    icon: ImageVector? = null,
    onPick: (String) -> Unit,
) {
    // State that tells us whether the list can scroll further.
    val scrollableState = rememberLazyListState()

    // If there are no size values, show the empty state UI.
    if (data.isEmpty()) {
        EmptyState(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(Theme.color.neutral0),
            title = title,
            description = description,
            action = null,
            onAction = {},
        )
    } else {
        // Main content – a column containing a header, an animated divider
        // (visible when the list can scroll), and the list of sizes.
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(Theme.color.neutral0),
        ) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(Theme.spacing.space8),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                icon?.let {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = Theme.color.neutral2,
                        modifier = Modifier.size(Theme.size.size32),
                    )
                }
                // Header text, replace with meaningful content in real usage.
                Text(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(Theme.spacing.space8),
                    text = header,
                    minLines = 1,
                    style = Theme.typography.title,
                    color = Theme.color.neutral2,
                )
            }

            // Divider that becomes visible when the list can scroll forward.
            AnimatedDivider(
                modifier = Modifier.fillMaxWidth(),
                isVisible = scrollableState.canScrollForward,
            )

            // LazyColumn that displays all available sizes.
            LazyColumn(
                state = scrollableState,
                modifier =
                    modifier
                        .fillMaxSize()
                        .background(Theme.color.neutral0)
                        .padding(horizontal = Theme.spacing.space8),
                horizontalAlignment = Alignment.Start,
            ) {
                items(data) { item ->
                    SecondaryItem(
                        modifier = Modifier,
                        text = item,
                        isSelected = item == selected,
                        onClick = {
                            onPick(item)
                        },
                    )
                }
            }
        }
    }
}
