package dev.yactt.presentation.feature.onboarding.core.ext

import androidx.compose.foundation.pager.PagerState

fun PagerState.startOffsetForPage(page: Int): Float = (currentPage - page) + currentPageOffsetFraction

fun PagerState.isLastPage(): Boolean = currentPage == pageCount - 1

suspend fun PagerState.animateScrollToNextPage() {
    if (!isLastPage()) {
        animateScrollToPage(currentPage + 1)
    }
}
