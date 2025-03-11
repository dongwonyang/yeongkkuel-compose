package project.compose.presentation.navigation

import androidx.annotation.DrawableRes
import project.compose.presentation.R

sealed class Screen(val route: String) {
    sealed class BotScreen(
        val bRoute: String,
        val title: String,
        @DrawableRes val bIcon: Int
    ) : Screen(route = bRoute) {
        data object HomeScreen : BotScreen(
            bRoute = "home_screen",
            title = "홈",
            bIcon = R.drawable.ic_navigation_home
        )

        data object ChatScreen : BotScreen(
            bRoute = "chat_screen",
            title = "채팅",
            bIcon = R.drawable.ic_navigation_chat
        )

        data object StatScreen : BotScreen(
            bRoute = "stat_screen",
            title = "지출",
            bIcon = R.drawable.ic_navigation_stat
        )

        data object ProfileScreen : BotScreen(
            bRoute = "profile_screen",
            title = "마이페이지",
            bIcon = R.drawable.ic_navigation_profile
        )
    }

    companion object{
        fun fromRoute(route: String): Screen =
            when(route){
                BotScreen.HomeScreen.bRoute -> BotScreen.HomeScreen
                BotScreen.ChatScreen.bRoute -> BotScreen.ChatScreen
                BotScreen.StatScreen.bRoute -> BotScreen.StatScreen
                BotScreen.ProfileScreen.bRoute -> BotScreen.ProfileScreen
                else -> Screen.BotScreen.HomeScreen
            }
    }
}

val screensInBot = listOf(
    Screen.BotScreen.HomeScreen,
    Screen.BotScreen.ChatScreen,
    Screen.BotScreen.StatScreen,
    Screen.BotScreen.ProfileScreen,
)

val screensShowBotSheet = listOf(
    Screen.BotScreen.HomeScreen,
    Screen.BotScreen.StatScreen
)