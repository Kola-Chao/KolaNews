package com.kola.news.core.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kola.news.core.ui.navigation.TopLevelDestination

@Stable
class KolaNewsAppState(
    val navController: NavHostController,
    val topLevelDestinations: List<TopLevelDestination>,
) {
    fun navigateToTopLevelDestination(destination: TopLevelDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun isTopLevelDestinationInHierarchy(
        destination: TopLevelDestination,
        navDestination: NavDestination?,
    ): Boolean {
        return navDestination?.hierarchy?.any { it.route == destination.route } ?: false
    }
}

@Composable
fun rememberKolaNewsAppState(
    topLevelDestinations: List<TopLevelDestination>,
    navController: NavHostController = rememberNavController(),
): KolaNewsAppState = remember(navController, topLevelDestinations) {
    KolaNewsAppState(
        navController = navController,
        topLevelDestinations = topLevelDestinations,
    )
}
