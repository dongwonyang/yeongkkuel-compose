package project.compose.presentation.utils

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import project.compose.presentation.navigation.Screen

fun NavController.navigateBottom(screen: Screen) {
    navigate(screen.route) {
        popUpTo(graph.findStartDestination().route ?: return@navigate) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}
