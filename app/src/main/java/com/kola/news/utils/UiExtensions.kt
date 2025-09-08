package com.kola.news.utils

import android.content.res.Configuration

/**
 * Convenience wrapper for dark mode checking
 */
val Configuration.isSystemInDarkTheme
    get() = (uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
