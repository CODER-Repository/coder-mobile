package com.coder.siakad.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryBlue500,
    secondary = PrimaryYellow50,
    tertiary = PrimaryBlue500
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue500,
    onPrimary = Color.White,
    secondary = PrimaryYellow50,
    onSecondary = Color.White,
    tertiary = PrimaryBlue500,
    onTertiary = Color.White,
    background = PrimaryBackground,
    onBackground = TextPrimary,
    surface = PrimaryBackground,
    onSurface = TextPrimary,
    surfaceVariant = Color.White,
    onSurfaceVariant = TextPrimary,
    primaryContainer = ContainerPrimary,
    onPrimaryContainer = TextPrimary,
    tertiaryContainer = ContainerPrimary,
    onTertiaryContainer = TextPrimary,
    error = Error,
    onError = OnError,
    errorContainer = ContainerError,
    onErrorContainer = OnErrorContainer,
    outline = Outline
)

@Composable
fun SiakadTheme(
    darkTheme: Boolean = false,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}