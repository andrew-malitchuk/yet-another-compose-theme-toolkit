package dev.yactt.presentation.core.ui.core.util.window

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable

class WindowSizeHelper {
    companion object {
        @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
        @Composable
        fun shouldUseExpandedLayout(): Boolean {
            val windowSizeClass = calculateWindowSizeClass()
            return when {
                windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact -> false
                else -> true
            }
        }

        @Composable
        fun isInCompactMode(): Boolean = !shouldUseExpandedLayout()

        fun inInCompactMode(
            isInCompactMode: Boolean,
            inCompactMode: () -> Unit,
            inExpandedMode: () -> Unit,
        ) {
            if (isInCompactMode) {
                inCompactMode()
            } else {
                inExpandedMode()
            }
        }
    }
}
