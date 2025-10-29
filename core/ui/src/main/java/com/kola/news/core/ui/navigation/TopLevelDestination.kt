package com.kola.news.core.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class TopLevelDestination(
    override val route: String,
    override val destination: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val iconTextId: Int,
) : KolaNewsNavigationDestination
