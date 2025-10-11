package dev.yactt.presentation.feature.theme.size.source.size

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.core.ext.makeScrollable
import dev.yactt.presentation.core.ui.source.layout.CompactContainer
import dev.yactt.presentation.core.ui.source.widget.header.SimpleHeader
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.size.SizeConfigurator
import dev.yactt.presentation.feature.theme.size.source.size.mvi.ThemeSizeIntent
import dev.yactt.presentation.feature.theme.size.source.size.mvi.ThemeSizeState

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ThemeSizeView(
    modifier: Modifier = Modifier,
    isInCompactMode: Boolean,
    state: ThemeSizeState,
    onIntent: (ThemeSizeIntent) -> Unit,
) {
    val localisation = LocalLocalisation.current
    val scrollableState = rememberScrollState()

    CompactContainer(
        modifier =
            modifier
                .background(Theme.color.neutral0)
                .statusBarsPadding(),
        isInCompactMode = isInCompactMode,
        headerContent = {
            SimpleHeader(
                title = localisation.theme.size,
                isDividerVisible = scrollableState.canScrollBackward,
                onNavClick = {
                    onIntent(ThemeSizeIntent.OnBackClickIntent)
                },
            )
        },
        mainContent = {
            Column(
                modifier =
                    modifier
                        .fillMaxSize()
                        .background(Theme.color.neutral0)
                        .padding(horizontal = Theme.spacing.space16)
                        .makeScrollable(),
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.space8),
            ) {
                SizeConfigurator(
                    modifier = Modifier.weight(1f),
                    state = state.content,
                    scrollableState = scrollableState,
                    onAddClick = {
                        onIntent(ThemeSizeIntent.AddSizeIntent)
                    },
                    onRemoveClick = {
                        onIntent(ThemeSizeIntent.RemoveSizeIntent(it))
                    },
                )
            }
        },
    )
}
