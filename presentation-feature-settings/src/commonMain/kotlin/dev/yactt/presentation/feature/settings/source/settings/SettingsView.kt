package dev.yactt.presentation.feature.settings.source.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.yactt.domain.core.source.model.FrameworkEntity
import dev.yactt.domain.core.source.model.LanguageEntity
import dev.yactt.domain.core.source.model.ThemeEntity
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.core.ext.makeScrollable
import dev.yactt.presentation.core.ui.source.icon.Question
import dev.yactt.presentation.core.ui.source.layout.CompactContainer
import dev.yactt.presentation.core.ui.source.widget.button.icon.primary.PrimaryIconButton
import dev.yactt.presentation.core.ui.source.widget.button.text.TextButton
import dev.yactt.presentation.core.ui.source.widget.header.SimpleHeader
import dev.yactt.presentation.core.ui.source.widget.item.SettingsItem
import dev.yactt.presentation.core.ui.source.widget.switch.SwitchButton
import dev.yactt.presentation.feature.settings.source.settings.mvi.SettingsIntent
import dev.yactt.presentation.feature.settings.source.settings.mvi.SettingsState

@Composable
fun SettingsView(
    modifier: Modifier = Modifier,
    isInCompactMode: Boolean,
    state: SettingsState,
    onIntent: (SettingsIntent) -> Unit,
) {
    val localisation = LocalLocalisation.current

    CompactContainer(
        modifier = modifier.background(Theme.color.neutral0).statusBarsPadding(),
        isInCompactMode = isInCompactMode,
        headerContent = {
            SimpleHeader(
                title = localisation.settings.title,
                isDividerVisible = false,
                onNavClick = {
                    onIntent(SettingsIntent.OnNavBackIntent)
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
                SettingsItem(title = localisation.settings.darkMode) {
                    SwitchButton(
                        initValue = state.theme?.isDark ?: true,
                        value = state.theme?.isDark ?: true,
                        onStateChange = {
                            onIntent(
                                SettingsIntent.OnThemeChangeIntent(
                                    ThemeEntity.entries.first { theme ->
                                        theme.isDark == it
                                    },
                                ),
                            )
                        },
                    )
                }
                SettingsItem(title = localisation.settings.language) {
                    Row {
                        TextButton(
                            text = "ua",
                            isSelected = state.language == LanguageEntity.UKRAINIAN,
                        ) {
                            onIntent(SettingsIntent.OnLanguageChangeIntent(LanguageEntity.UKRAINIAN))
                        }
                        TextButton(
                            text = "en",
                            isSelected = state.language == LanguageEntity.ENGLISH,
                        ) {
                            onIntent(SettingsIntent.OnLanguageChangeIntent(LanguageEntity.ENGLISH))
                        }
                    }
                }
                SettingsItem(title = localisation.settings.type) {
                    Row {
                        TextButton(
                            text = "Native",
                            isSelected = state.framework == FrameworkEntity.NATIVE,
                        ) {
                            onIntent(SettingsIntent.OnFrameworkChangeIntent(FrameworkEntity.NATIVE))
                        }
                        TextButton(
                            text = "KMP",
                            isSelected = state.framework == FrameworkEntity.CMP,
                        ) {
                            onIntent(SettingsIntent.OnFrameworkChangeIntent(FrameworkEntity.CMP))
                        }
                    }
                }
                SettingsItem(title = localisation.settings.about) {
                    PrimaryIconButton(
                        modifier = Modifier,
                        icon = Question,
                        onClick = {
                            onIntent(SettingsIntent.OnAboutIntent)
                        },
                    )
                }
            }
        },
    )
}
