package project.compose.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import project.compose.presentation.screen.home.HomeView

@Composable
fun Navigation(
    navController: NavHostController,
    pd: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screen.BotScreen.HomeScreen.route,
        modifier = Modifier.padding(pd)
    ) {
        composable(route = Screen.BotScreen.HomeScreen.route) {
            HomeView(navController = navController)
        }

        composable(route = Screen.BotScreen.ChatScreen.route) {

        }


        composable(route = Screen.BotScreen.StatScreen.route) {

        }


        composable(route = Screen.BotScreen.ProfileScreen.route) {

        }
    }
}