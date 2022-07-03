package com.github.ryutaro.feature_home.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.ryutaro.core_navigation.DailyRankingNavigationDestination
import com.github.ryutaro.feature_home.HomeScreenRoute

object HomeScreenDestination : DailyRankingNavigationDestination {
    override val destination: String
        get() = "home_screen_destination"
    override val route: String
        get() = "home_screen_route"
}

fun NavGraphBuilder.homeScreenGraph(
    windowSizeClass: WindowSizeClass
) {
    composable(route = HomeScreenDestination.route) {
        HomeScreenRoute(windowSizeClass)
    }
}
