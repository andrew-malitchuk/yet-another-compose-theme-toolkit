package dev.yactt.presentation.feature.onboarding.core.components.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import dev.yactt.presentation.core.styling.core.Theme
import dev.yactt.presentation.feature.onboarding.core.configure.OnboardingPage
import dev.yactt.presentation.feature.onboarding.core.ext.startOffsetForPage
import kotlin.math.absoluteValue

@Composable
fun ParallaxOnboardingPage(
    isHorizontal: Boolean,
    pageData: OnboardingPage,
    pagerState: PagerState,
    pageIndex: Int,
) {
    val pageOffset = pagerState.startOffsetForPage(pageIndex)

    if (isHorizontal) {
        Row(modifier = Modifier.fillMaxSize()) {
            // Background with Parallax Effect
            Box(
                modifier =
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .graphicsLayer {
                            alpha = 1 - pageOffset
                            translationX = -(pageOffset * 500f) // Moves background slower for parallax
                        },
            ) {
                Box(
                    modifier =
                        Modifier
                            .padding(Theme.spacing.space8)
                            .fillMaxSize()
                            .clip(RoundedCornerShape(Theme.spacing.space16))
                            .background(pageData.color),
                ) {
                    Image(
                        imageVector = pageData.imageVector,
                        contentDescription = null,
                        modifier =
                            Modifier
                                .fillMaxSize()
                                .padding(Theme.spacing.space32)
                                .graphicsLayer {
                                    translationX =
                                        pageOffset * 200f // Moves image slightly for parallax
                                },
                    )
                }
            }

            // Foreground Content (Text & Button)
            Column(
                modifier =
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(Theme.spacing.space16)
                        .graphicsLayer {
                            val scale = 1f - 0.2f * pageOffset.absoluteValue
                            scaleX = scale
                            scaleY = scale
                            alpha =
                                (1f - pageOffset.absoluteValue * 0.3f).coerceIn(0f, 1f) // Fade effect
                        },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = pageData.title,
                    style = Theme.typography.headline,
                    color = Theme.color.neutral2,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(Theme.spacing.space8))
                Text(
                    text = pageData.description,
                    style = Theme.typography.title,
                    color = Theme.color.neutral1,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(Theme.spacing.space16))
            }
        }
    } else {
        Column(modifier = Modifier.fillMaxSize()) {
            // Background with Parallax Effect
            Box(
                modifier =
                    Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .graphicsLayer {
                            alpha = 1 - pageOffset
                            translationX = -(pageOffset * 500f) // Moves background slower for parallax
                        },
            ) {
                Box(
                    modifier =
                        Modifier
                            .padding(Theme.spacing.space8)
                            .fillMaxSize()
                            .clip(RoundedCornerShape(Theme.spacing.space16))
                            .background(pageData.color),
                ) {
                    Image(
                        imageVector = pageData.imageVector,
                        contentDescription = null,
                        modifier =
                            Modifier
                                .fillMaxSize()
                                .padding(Theme.spacing.space32)
                                .graphicsLayer {
                                    translationX =
                                        pageOffset * 200f // Moves image slightly for parallax
                                },
                    )
                }
            }

            // Foreground Content (Text & Button)
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(Theme.spacing.space16)
                        .graphicsLayer {
                            val scale = 1f - 0.2f * pageOffset.absoluteValue
                            scaleX = scale
                            scaleY = scale
                            alpha =
                                (1f - pageOffset.absoluteValue * 0.3f).coerceIn(0f, 1f) // Fade effect
                        },
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = pageData.title,
                    style = Theme.typography.headline,
                    color = Theme.color.neutral2,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(Theme.spacing.space8))
                Text(
                    text = pageData.description,
                    style = Theme.typography.title,
                    color = Theme.color.neutral1,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(Theme.spacing.space16))
            }
        }
    }
}
