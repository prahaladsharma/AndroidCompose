package com.jetnews.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController


object AppDestination{
    const val HOME_ROUTE = "home"
    const val INTERESTS_ROUTE = "interests"
}

/**
 * Models the navigation actions in the app.
 */
@Composable
fun JetNewsNavigationActions(
    navController: NavHostController
) {
    val navigateToHome: () -> Unit = {
        navController.navigate(AppDestination.HOME_ROUTE){
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true // Avoid multiple copies of the same destination when reSelecting the same item
            restoreState = true  // Restore state when reselecting a previously selected item
        }
    }

    val navigateToInterests: () -> Unit = {
        navController.navigate(AppDestination.INTERESTS_ROUTE){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}