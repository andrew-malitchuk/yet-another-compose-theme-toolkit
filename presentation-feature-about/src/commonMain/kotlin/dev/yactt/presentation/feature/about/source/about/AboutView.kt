package dev.yactt.presentation.feature.about.source.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.core.ext.makeScrollable
import dev.yactt.presentation.core.ui.source.icon.Github
import dev.yactt.presentation.core.ui.source.layout.CompactContainer
import dev.yactt.presentation.core.ui.source.widget.button.icon.primary.PrimaryIconButton
import dev.yactt.presentation.core.ui.source.widget.header.SimpleHeader
import dev.yactt.presentation.core.ui.source.widget.item.SettingsItem
import dev.yactt.presentation.feature.about.source.about.mvi.AboutIntent

@Composable
fun AboutView(
    modifier: Modifier = Modifier,
    isInCompactMode: Boolean,
    onIntent: (AboutIntent) -> Unit,
) {
    val localisation = LocalLocalisation.current

    CompactContainer(
        modifier =
            modifier
                .background(Theme.color.neutral0)
                .statusBarsPadding(),
        isInCompactMode = isInCompactMode,
        headerContent = {
            SimpleHeader(
                title = localisation.settings.title,
                isDividerVisible = false,
                onNavClick = {
                    onIntent(AboutIntent.OnBackClickIntent)
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
                Text(
                    text = localisation.about.title,
                    overflow = TextOverflow.Ellipsis,
                    style = Theme.typography.subHeading,
                    color = Theme.color.neutral2,
                )
                Spacer(Modifier.height(Theme.spacing.space8))
                Text(
                    text = localisation.about.about,
                    overflow = TextOverflow.Ellipsis,
                    style = Theme.typography.body,
                    color = Theme.color.neutral2,
                )
                Spacer(
                    modifier =
                        Modifier
                            .height(Theme.spacing.space32),
                )
                SettingsItem(title = localisation.settings.github) {
                    PrimaryIconButton(
                        modifier = Modifier,
                        icon = Github,
                        onClick = {
                            onIntent(AboutIntent.OnGithubClickIntent)
                        },
                    )
                }
            }
        },
    )
}
