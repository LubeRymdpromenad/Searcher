package com.example.explorer.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = green,
    secondary = green,
    tertiary = green,
)

private val LightColorScheme = lightColorScheme(
    primary = green,
    onPrimary = Color.Black,
    secondary = green,
    onSecondary = Color.Black,
    tertiary = Color.Gray,
    onTertiary = green,
    primaryContainer = green,
    onPrimaryContainer = Color.Blue,
    inversePrimary = green,
    secondaryContainer = green,
    onSecondaryContainer = green,
    tertiaryContainer = green,
    onTertiaryContainer = green,
    background = Color.White,
    onBackground = Color.Black,
    surface = green,
    onSurface = Color.Black,
    surfaceVariant = green,
    onSurfaceVariant = green,
    surfaceTint = green,
    inverseSurface = green,
    inverseOnSurface = green,
    error = Color.Red,
    onError = green,
    errorContainer = green,
    onErrorContainer = green,
    outline = green,
    outlineVariant = green,
    scrim = green,
)

@Composable
fun ExplorerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = if (darkTheme) {
            DarkColorScheme.primary
        } else {
            LightColorScheme.primary
        }
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
