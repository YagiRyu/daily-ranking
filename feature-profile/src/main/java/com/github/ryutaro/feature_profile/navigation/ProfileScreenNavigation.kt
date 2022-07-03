package com.github.ryutaro.feature_profile.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.ryutaro.core_navigation.DailyRankingNavigationDestination
import com.github.ryutaro.feature_profile.ProfileScreenRoute

object ProfileScreenNavigation : DailyRankingNavigationDestination {
    override val destination: String
        get() = "profile_screen_destination"
    override val route: String
        get() = "profile_screen_route"
}

fun NavGraphBuilder.profileScreenGraph(
    windowSizeClass: WindowSizeClass
) {
    composable(route = ProfileScreenNavigation.route) {
        ProfileScreenRoute(windowSizeClass = windowSizeClass)
    }
}
