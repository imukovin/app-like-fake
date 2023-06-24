package com.imukstudio.applikefake.design_system.theme

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

/**
 * These colors are needed for elements that do not change colors.
 */
private val pureBlack = Color(0xFF000000)
private val black = Color(0xFF393939)


@Immutable
data class AppLikeFakeColors(
    val background: BackgroundColors,
    val text: TextColors,
    val element: ElementColors,
    val constant: ConstantColors,
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

    data class ConstantColors(
        val pureBlack: Color,
        val black: Color,
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
        constant = AppLikeFakeColors.ConstantColors(
            pureBlack = pureBlack,
            black = black,
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
        constant = AppLikeFakeColors.ConstantColors(
            pureBlack = pureBlack,
            black = black,
        ),
        isLight = false,
    )
}

val LocalAppLikeFakeColors = staticCompositionLocalOf { lightColors }
