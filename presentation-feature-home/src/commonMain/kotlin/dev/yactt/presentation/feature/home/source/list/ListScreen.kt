package dev.yactt.presentation.feature.home.source.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    isInCompactMode: Boolean,
    onAction: (ListAction) -> Unit,
) {
    ListView(
        modifier = modifier,
        isInCompactMode = isInCompactMode,
        onAction = onAction,
    )
}
