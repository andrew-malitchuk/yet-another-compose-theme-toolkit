package dev.yactt.presentation.core.localisation.source.locale

import dev.yactt.presentation.core.localisation.source.AboutLocalisation
import dev.yactt.presentation.core.localisation.source.HomeLocalisation
import dev.yactt.presentation.core.localisation.source.Localisation
import dev.yactt.presentation.core.localisation.source.OnboardingLocalisation
import dev.yactt.presentation.core.localisation.source.SettingsLocalisation
import dev.yactt.presentation.core.localisation.source.ThemeLocalisation

val localeUk = Localisation(
    onboarding = OnboardingLocalisation(
        page1Title = "Ласкаво просимо до YACTT",
        page1Description = "Створюйте унікальні теми для ваших додатків Android/CMP.",
        page2Title = "Налаштуйте свою тему",
        page2Description = "Виберіть кольори, типографіку та інші параметри дизайну.",
        page3Title = "Експортуйте та використовуйте",
        page3Description = "Експортуйте свою тему та інтегруйте її у свій додаток.",
    ),
    settings = SettingsLocalisation(
        title = "Налаштування",
        darkMode = "Темна тема",
        language = "Мова",
        type = "Тип фреймворку",
        github = "GitHub",
        about = "Про цей додаток",
    ),
    about = AboutLocalisation(
        title = "Про цей додаток",
        about = "YACTT - це інструмент для створення тем для ваших додатків Android/CMP. Він дозволяє налаштовувати кольори, типографіку та інші аспекти дизайну вашого додатку, забезпечуючи унікальний вигляд і відчуття."
    ),
    home = HomeLocalisation(
        palette = "Палітра",
        fontSize = "Розмір шрифту",
        size = "Розмір",
        lineHeight = "Висота рядка",
        offset = "Відступ",
        typography = "Типографіка",
        fontFamily = "Сімейство шрифтів",
        packageName = "your.package",
    ),
    theme = ThemeLocalisation(
        color = "Колір",
        typography = "Типографіка",
        fontSize = "Розмір шрифту",
        fontFamily = "Сімейство шрифтів",
        size = "Розмір",
        linesize = "Розмір рядка",
        offset = "Відступ",
        fontWeight = "Вага",
        fontResource = "Будь ласка, додайте ресурси шрифтів у ваш проект; він має мати таку ж назву, як і `Назва`.",
        style = "Стиль шрифту",
    ),
    general = dev.yactt.presentation.core.localisation.source.GeneralLocalisation(
        name = "Назва",
        nothingTitle = "Нічого не знайдено",
        nothingDescription = "Спробуйте додати артефакти",
        welcomeTitle = "Ласкаво просимо до YACTT",
        welcomeDescription = "Давайте створимо тему вашого додатку разом!",
        errorPackage = "Недійсна назва пакету"
    )
)