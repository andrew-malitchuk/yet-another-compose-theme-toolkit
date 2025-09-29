package dev.yactt.presentation.feature.onboarding.source.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import dev.yactt.domain.core.source.model.LanguageEntity
import dev.yactt.presentation.core.localisation.source.provider.LocalLocalisation
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.core.ui.source.icon.ArrowRight
import dev.yactt.presentation.core.ui.source.icon.Package
import dev.yactt.presentation.core.ui.source.icon.Palette
import dev.yactt.presentation.core.ui.source.icon.TextAa
import dev.yactt.presentation.core.ui.source.widget.button.icon.primary.PrimaryIconButton
import dev.yactt.presentation.core.ui.source.widget.button.text.TextButton
import dev.yactt.presentation.feature.onboarding.core.components.widget.ParallaxOnboardingPage
import dev.yactt.presentation.feature.onboarding.core.configure.OnboardingPage
import dev.yactt.presentation.feature.onboarding.core.ext.animateScrollToNextPage
import dev.yactt.presentation.feature.onboarding.core.ext.isLastPage
import dev.yactt.presentation.feature.onboarding.source.onboarding.mvi.OnboardingIntent
import dev.yactt.presentation.feature.onboarding.source.onboarding.mvi.OnboardingState
import kotlinx.coroutines.launch

@Composable
fun OnboardingView(
    modifier: Modifier = Modifier,
    isInCompactMode: Boolean,
    state: OnboardingState,
    onIntent: (OnboardingIntent) -> Unit,
) {
    val localisation = LocalLocalisation.current

    val pages =
        listOf(
            OnboardingPage(
                localisation.onboarding.page1Title,
                localisation.onboarding.page1Description,
                Theme.color.accent0,
                Palette,
            ),
            OnboardingPage(
                localisation.onboarding.page2Title,
                localisation.onboarding.page2Description,
                Theme.color.accent0,
                Package,
            ),
            OnboardingPage(
                localisation.onboarding.page3Title,
                localisation.onboarding.page3Description,
                Theme.color.accent0,
                TextAa,
            ),
        )

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { pages.size })

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .background(Theme.color.neutral0)
                .navigationBarsPadding()
                .statusBarsPadding(),
    ) {
        Box(
            modifier =
                modifier
                    .weight(1f)
                    .fillMaxWidth(),
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
            ) { page ->
                ParallaxOnboardingPage(isHorizontal = !isInCompactMode, pageData = pages[page], pagerState, page)
            }
        }
        Row(
            modifier =
                Modifier
                    .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row {
                TextButton(
                    text = "ua",
                    isSelected = state.language == LanguageEntity.UKRAINIAN,
                ) {
                    onIntent(OnboardingIntent.OnLanguageChangeIntent(LanguageEntity.UKRAINIAN))
                }
                TextButton(
                    text = "en",
                    isSelected = state.language == LanguageEntity.ENGLISH,
                ) {
                    onIntent(OnboardingIntent.OnLanguageChangeIntent(LanguageEntity.ENGLISH))
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                textAlign = TextAlign.Center,
                color = Theme.color.neutral1,
                style = Theme.typography.caption,
                text = "${pagerState.currentPage + 1}/${pagerState.pageCount}",
            )
            Spacer(modifier = Modifier.width(Theme.spacing.space8))
            PrimaryIconButton(
                modifier =
                    Modifier
                        .padding(Theme.spacing.space8),
                icon = ArrowRight,
                onClick = {
                    when (pagerState.isLastPage()) {
                        true -> onIntent(OnboardingIntent.GoToHomeIntent)
                        false -> coroutineScope.launch { pagerState.animateScrollToNextPage() }
                    }
                },
            )
        }
    }
}
