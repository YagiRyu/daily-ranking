package com.github.ryutaro.daily_ranking.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.ryutaro.core_designsystem.theme.DailyrankingTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun DailyRankingApp(windowSizeClass: WindowSizeClass) {
    DailyrankingTheme {
        val navController = rememberNavController()
        val dailyRankingAppNavigation = remember(navController) {
            DailyRankingTopLevelNavigation(navController)
        }

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        Scaffold(
            modifier = Modifier.padding(bottom = 0.dp),
            contentColor = MaterialTheme.colorScheme.onBackground,
            bottomBar = {
                if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
                    DailyRankingAppBottomBar(
                        onNavigateToTopLevelNavigation = dailyRankingAppNavigation::navigateTo,
                        currentDestination = currentDestination
                    )
                }
            }
        ) { paddingValues ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal))
            ) {
                if (windowSizeClass.widthSizeClass != WindowWidthSizeClass.Compact) {
                    DailyRankingAppNavigationRail(
                        onNavigateToTopLevelNavigation = dailyRankingAppNavigation::navigateTo,
                        currentDestination = currentDestination,
                        modifier = Modifier.safeDrawingPadding()
                    )
                }

                DailyRankingNavHost(
                    windowSizeClass = windowSizeClass,
                    navController = navController,
                    modifier = Modifier
                        .padding(paddingValues)
                        .consumedWindowInsets(paddingValues),
                )
            }
        }
    }
}

@Composable
private fun DailyRankingAppNavigationRail(
    onNavigateToTopLevelNavigation: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier) {
        TOP_LEVEL_DESTINATION.forEach { destination ->
            val selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true
            NavigationRailItem(
                selected = selected,
                onClick = { onNavigateToTopLevelNavigation(destination) },
                icon = {
                    Icon(
                        if (selected) destination.selectedIcon else destination.unSelectedIcon,
                        contentDescription = null
                    )
                },
                label = { Text(text = stringResource(id = destination.iconTextId)) }
            )
        }
    }
}

@Composable
private fun DailyRankingAppBottomBar(
    onNavigateToTopLevelNavigation: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    Surface(color = MaterialTheme.colorScheme.surface) {
        NavigationBar(
            modifier = Modifier.windowInsetsPadding(
                WindowInsets.safeDrawing.only(
                    WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
                )
            ),
            tonalElevation = 0.dp
        ) {
            TOP_LEVEL_DESTINATION.forEach { destination ->
                val selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true
                NavigationBarItem(
                    selected = selected,
                    onClick = { onNavigateToTopLevelNavigation(destination) },
                    icon = {
                        Icon(
                            if (selected) {
                                destination.selectedIcon
                            } else {
                                destination.unSelectedIcon
                            },
                            contentDescription = null
                        )
                    },
                    label = { Text(text = stringResource(id = destination.iconTextId)) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480")
@Preview(device = "spec:shape=Normal,width=673,height=841,unit=dp,dpi=480")
@Preview(device = "spec:shape=Normal,width=1280,height=801,unit=dp,dpi=480")
@Composable
fun DailyRankingAppPreview() {
    BoxWithConstraints {
        DailyrankingTheme {
            DailyRankingApp(
                windowSizeClass = WindowSizeClass.calculateFromSize(
                    DpSize(
                        maxWidth,
                        minHeight
                    )
                )
            )
        }
    }
}

