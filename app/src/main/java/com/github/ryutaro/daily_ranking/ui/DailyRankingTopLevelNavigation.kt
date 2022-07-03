package com.github.ryutaro.daily_ranking.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.github.ryutaro.daily_ranking.R
import com.github.ryutaro.feature_home.navigation.HomeScreenDestination
import com.github.ryutaro.feature_profile.navigation.ProfileScreenNavigation

class DailyRankingTopLevelNavigation(private val navController: NavController) {
    fun navigateTo(destination: TopLevelDestination) {
        navController.navigate(destination.route) {

            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

data class TopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val iconTextId: Int
)

val TOP_LEVEL_DESTINATION = listOf(
    TopLevelDestination(
        route = HomeScreenDestination.route,
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
        iconTextId = R.string.home
    ),
    TopLevelDestination(
        route = ProfileScreenNavigation.route,
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
        iconTextId = R.string.profile
    )
)
