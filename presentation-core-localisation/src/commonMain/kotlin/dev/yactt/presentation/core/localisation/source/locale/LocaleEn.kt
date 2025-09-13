package dev.yactt.presentation.core.localisation.source.locale

import dev.yactt.presentation.core.localisation.source.AboutLocalisation
import dev.yactt.presentation.core.localisation.source.HomeLocalisation
import dev.yactt.presentation.core.localisation.source.Localisation
import dev.yactt.presentation.core.localisation.source.OnboardingLocalisation
import dev.yactt.presentation.core.localisation.source.SettingsLocalisation
import dev.yactt.presentation.core.localisation.source.ThemeLocalisation
import kotlin.math.abs

val localeEn = Localisation(
    onboarding = OnboardingLocalisation(
        page1Title = "Welcome to YACTT",
        page1Description = "Let's create your app's theme together!",
        page2Title = "Customize your theme",
        page2Description = "Choose colors, typography, and more to make your app unique.",
        page3Title = "Export and use",
        page3Description = "Export your theme and integrate it into your Android/CMP app easily."
    ),
    settings = SettingsLocalisation(
        title = "Settings",
        darkMode = "Dark mode",
        language = "Language",
        type = "Framework's type",
        github = "GitHub",
        about = "About"
    ),
    about = AboutLocalisation(
        title = "About",
        about = "YACTT is a tool to create themes for your Android/CMP apps. It allows you to customize colors, typography, and other design aspects of your app, providing a unique look and feel."
    ),
    home = HomeLocalisation(
        palette = "Palette",
        fontSize = "Font size",
        size = "Size",
        lineHeight = "Line height",
        offset = "Offset",
        typography = "Typography",
        fontFamily = "Font family",
        packageName = "your.package",
    ),
    theme = ThemeLocalisation(
        color = "Color",
        typography = "Typography",
        fontSize = "Font size",
        fontFamily = "Font family",
        size = "Size",
        linesize = "Line size",
        offset = "Offset",
        fontWeight = "Font weight",
        fontResource = "Please, add font resources in your project; it has to have the same name as `Name`.",
        style = "Font weight",
    ),
    general = dev.yactt.presentation.core.localisation.source.GeneralLocalisation(
        name = "Name",
        nothingTitle = "Nothing found",
        nothingDescription = "Try adding artifacts",
        welcomeTitle = "Welcome to YACTT",
        welcomeDescription = "Let's create your app's theme together!",
        errorPackage= "Invalid package name"
    )
)