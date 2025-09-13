package dev.yactt.presentation.core.localisation.source.provider

import androidx.compose.runtime.staticCompositionLocalOf
import dev.yactt.presentation.core.localisation.source.Localisation

val LocalLocalisation =
    staticCompositionLocalOf<Localisation> {
        error("No implementation")
    }