package com.imukstudio.applikefake.design_system.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Immutable
data class AppLikeFakeTypography(
    val headline1: TextStyle,
    val headline2: TextStyle,
    val headline3: TextStyle,
    val title: TextStyle,
    val paragraph1: TextStyle,
    val paragraph2: TextStyle,
    val paragraph3: TextStyle,
    val caption1: TextStyle,
)

val LocalAppLikeFakeTypography = staticCompositionLocalOf {
    AppLikeFakeTypography(
        headline1 = TextStyle.Default,
        headline2 = TextStyle.Default,
        headline3 = TextStyle.Default,
        title = TextStyle.Default,
        paragraph1 = TextStyle.Default,
        paragraph2 = TextStyle.Default,
        paragraph3 = TextStyle.Default,
        caption1 = TextStyle.Default,
    )
}


val appLikeFakeTypography: AppLikeFakeTypography
    @Composable
    get() = AppLikeFakeTypography(
        headline1 = TextStyle(
            fontSize = 32.sp,
            lineHeight = 36.sp
        ).bold,
        headline2 = TextStyle(
            fontSize = 24.sp,
            lineHeight = 28.sp
        ).bold,
        headline3 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 24.sp
        ).bold,
        title = TextStyle(
            fontSize = 18.sp,
            lineHeight = 20.sp
        ).demiBold,
        paragraph1 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp
        ),
        paragraph2 = TextStyle(
            fontSize = 14.sp,
            lineHeight = 16.sp
        ),
        paragraph3 = TextStyle(
            fontSize = 12.sp,
            lineHeight = 14.sp
        ),
        caption1 = TextStyle(
            letterSpacing = TextUnit.Unspecified,
            fontSize = 10.sp,
            lineHeight = 12.sp,
        )
    )

val TextStyle.bold: TextStyle
    get() = copy(fontWeight = FontWeight(700))

val TextStyle.demiBold: TextStyle
    get() = copy(fontWeight = FontWeight(600))

val TextStyle.medium: TextStyle
    get() = copy(fontWeight = FontWeight(500))

val TextStyle.regular: TextStyle
    get() = copy(fontWeight = FontWeight(400))

val TextStyle.strikethrough: TextStyle
    get() = copy(textDecoration = TextDecoration.LineThrough)
