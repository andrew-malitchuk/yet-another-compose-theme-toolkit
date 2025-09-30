package dev.yactt.presentation.feature.onboarding.core.configure

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class OnboardingPage(
    val title: String,
    val description: String,
    val color: Color,
    val imageVector: ImageVector,
)
