package com.imujstudio.applikefake.design_system.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Background colors.
 */
// The main background colors.
private val backgroundPrimaryLight = Color(0xFFFFFFFF)
private val backgroundPrimaryDark = Color(0xFF393939)

/**
 * Text colors.
 */
// The main text colors.
private val textPrimaryLight = Color(0xFF000000)
private val textPrimaryDark = Color(0xFFFFFFFF)

/**
 * Elements colors.
 */
// The main elements colors.
private val elementPrimaryLight = Color(0xFFFDEECB)
private val elementPrimaryDark = Color(0xFFFDEECB)

private val elementSecondaryLight = Color(0xFFD7DDEA)
private val elementSecondaryDark = Color(0xFFD7DDEA)

@Immutable
data class AppLikeFakeColors(
    val background: BackgroundColors,
    val text: TextColors,
    val element: ElementColors,
    val isLight: Boolean,
) {
    data class BackgroundColors(
        val primary: Color,
    )

    data class TextColors(
        val primary: Color,
    )

    data class ElementColors(
        val primary: Color,
        val secondary: Color,
    )
}

/**
 * Colors for light theme.
 */
val lightColors by lazy {
    AppLikeFakeColors(
        background = AppLikeFakeColors.BackgroundColors(
            primary = backgroundPrimaryLight,
        ),
        text = AppLikeFakeColors.TextColors(
            primary = textPrimaryLight,
        ),
        element = AppLikeFakeColors.ElementColors(
            primary = elementPrimaryLight,
            secondary = elementSecondaryLight,
        ),
        isLight = true,
    )
}

/**
 * Colors for dark theme.
 */
val darkColors by lazy {
    AppLikeFakeColors(
        background = AppLikeFakeColors.BackgroundColors(
            primary = backgroundPrimaryDark,
        ),
        text = AppLikeFakeColors.TextColors(
            primary = textPrimaryDark,
        ),
        element = AppLikeFakeColors.ElementColors(
            primary = elementPrimaryDark,
            secondary = elementSecondaryDark,
        ),
        isLight = false,
    )
}

val LocalAppLikeFakeColors = staticCompositionLocalOf { lightColors }
