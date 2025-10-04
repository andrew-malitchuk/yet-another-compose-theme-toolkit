package dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily

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
import dev.yactt.presentation.core.ui.source.widget.miscellaneous.font.FontFamilyConfigurator
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi.ThemeFontFamilyIntent
import dev.yactt.presentation.feature.theme.fontfamily.source.fontfamily.mvi.ThemeFontFamilyState

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ThemeFontFamilyView(
    modifier: Modifier = Modifier,
    isInCompactMode: Boolean,
    state: ThemeFontFamilyState,
    onIntent: (ThemeFontFamilyIntent) -> Unit,
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
                title = localisation.theme.fontFamily,
                isDividerVisible = scrollableState.canScrollBackward,
                onNavClick = {
                    onIntent(ThemeFontFamilyIntent.OnBackClickIntent)
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
                FontFamilyConfigurator(
                    modifier = Modifier.weight(1f),
                    state = state.content,
                    scrollableState = scrollableState,
                    onAddClick = {
                        onIntent(
                            ThemeFontFamilyIntent.AddFontFamilyIntent,
                        )
                    },
                    onRemoveClick = {
                        onIntent(
                            ThemeFontFamilyIntent.RemoveFontFamilyIntent(
                                it,
                            ),
                        )
                    },
                )
            }
        },
    )
}
