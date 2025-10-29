package com.kola.news

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kola.news.core.designsystem.icon.KolaNewsIcons
import com.kola.news.core.designsystem.theme.KolaNewsTheme
import com.kola.news.core.ui.navigation.TopLevelDestination
import com.kola.news.core.ui.state.rememberKolaNewsAppState
import com.kola.news.feature.home.HomeDestination
import com.kola.news.feature.home.HomeRoute
import com.kola.news.feature.profile.ProfileDestination
import com.kola.news.feature.profile.ProfileRoute

@Composable
fun KolaNewsApp() {
    val topLevelDestinations = remember {
        listOf(
            TopLevelDestination(
                route = HomeDestination.route,
                destination = HomeDestination.destination,
                selectedIcon = KolaNewsIcons.Home,
                unselectedIcon = KolaNewsIcons.HomeOutline,
                iconTextId = R.string.navigation_home,
            ),
            TopLevelDestination(
                route = ProfileDestination.route,
                destination = ProfileDestination.destination,
                selectedIcon = KolaNewsIcons.Profile,
                unselectedIcon = KolaNewsIcons.ProfileOutline,
                iconTextId = R.string.navigation_profile,
            ),
        )
    }

    val appState = rememberKolaNewsAppState(topLevelDestinations = topLevelDestinations)
    val navController = appState.navController
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    KolaNewsTheme {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    topLevelDestinations.forEach { destination ->
                        val selected = appState.isTopLevelDestinationInHierarchy(destination, currentDestination)
                        NavigationBarItem(
                            selected = selected,
                            onClick = { appState.navigateToTopLevelDestination(destination) },
                            icon = {
                                Icon(
                                    imageVector = if (selected) destination.selectedIcon else destination.unselectedIcon,
                                    contentDescription = stringResource(id = destination.iconTextId),
                                )
                            },
                            label = { Text(text = stringResource(id = destination.iconTextId)) },
                            alwaysShowLabel = false,
                        )
                    }
                }
            },
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = HomeDestination.route,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
            ) {
                composable(route = HomeDestination.route) {
                    HomeRoute()
                }
                composable(route = ProfileDestination.route) {
                    ProfileRoute()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun KolaNewsAppPreview() {
    KolaNewsApp()
}
