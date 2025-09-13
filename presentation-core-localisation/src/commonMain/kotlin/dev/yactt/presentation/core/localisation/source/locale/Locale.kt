package dev.yactt.presentation.core.localisation.source.locale

import dev.yactt.presentation.core.localisation.Language
import dev.yactt.presentation.core.localisation.source.Localisation

fun getLocalisation(language: Language): Localisation {
    return when(language){
        Language.English -> localeEn
        Language.Ukrainian -> localeUk
    }
}
