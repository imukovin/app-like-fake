package com.imukstudio.applikefake.design_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density

/**
 * The app theme. Container for the all app screens.
 *
 * @param isDarkTheme - is system in dark theme.
 * @param content - content of the screen.
 */
@Composable
fun AppLikeFakeTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val appLikeFakeColors = if (isDarkTheme) darkColors else lightColors

    CompositionLocalProvider(
        LocalAppLikeFakeColors provides appLikeFakeColors,
        LocalAppLikeFakeTypography provides appLikeFakeTypography,
        LocalDensity provides Density(
            density = LocalDensity.current.density,
            fontScale = LocalDensity.current.fontScale
        ),
        content = content
    )
}

object AppLikeFakeTheme {
    val color: AppLikeFakeColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppLikeFakeColors.current

    val typography: AppLikeFakeTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAppLikeFakeTypography.current

}
