package com.kola.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.kola.news.utils.isSystemInDarkTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        // We keep this as a mutable state, so that we can track changes inside the composition.
        // This allows us to react to dark/light mode changes.
//        var themeSettings by mutableStateOf(
//            ThemeSettings(
//                darkTheme = resources.configuration.isSystemInDarkTheme,
//                androidTheme = Loading.shouldUseAndroidTheme,
//                disableDynamicTheming = Loading.shouldDisableDynamicTheming,
//            ),
//        )
        // Keep the splash screen on-screen until the UI state is loaded. This condition is
        // evaluated each time the app needs to be redrawn so it should be fast to avoid blocking
        // the UI.
        splashScreen.setKeepOnScreenCondition { true }

    }
}

/**
 * Class for the system theme settings.
 * This wrapping class allows us to combine all the changes and prevent unnecessary recompositions.
 */
data class ThemeSettings(
    val darkTheme: Boolean,
    val androidTheme: Boolean,
    val disableDynamicTheming: Boolean,
)
