package com.github.ryutaro.daily_ranking.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.github.ryutaro.feature_home.navigation.HomeScreenDestination
import com.github.ryutaro.feature_home.navigation.homeScreenGraph
import com.github.ryutaro.feature_profile.navigation.profileScreenGraph

@Composable
fun DailyRankingNavHost(
    windowSizeClass: WindowSizeClass,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = HomeScreenDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeScreenGraph(
            windowSizeClass = windowSizeClass
        )
        profileScreenGraph(
            windowSizeClass = windowSizeClass
        )
    }
}
