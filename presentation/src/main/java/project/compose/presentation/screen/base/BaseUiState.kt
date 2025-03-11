package project.compose.presentation.screen.base

import project.compose.presentation.navigation.Screen

data class BaseUiState(
    val currentScreen: Screen = Screen.BotScreen.HomeScreen,
    val showBottomSheet: Boolean = true
)