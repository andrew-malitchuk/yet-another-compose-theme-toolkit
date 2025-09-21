package dev.yactt.presentation.core.ui.source.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CompactContainer(
    modifier: Modifier = Modifier,
    isInCompactMode: Boolean,
    headerContent: @Composable () -> Unit,
    mainContent: @Composable () -> Unit,
) {
    Column(
        modifier =
            modifier
                .fillMaxSize(),
    ) {
        if (!isInCompactMode) {
            headerContent()
        }
        mainContent()
    }
}
