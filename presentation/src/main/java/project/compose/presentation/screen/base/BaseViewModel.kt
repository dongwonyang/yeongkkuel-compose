package project.compose.presentation.screen.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import project.compose.presentation.navigation.Screen
import project.compose.presentation.navigation.screensShowBotSheet

class BaseViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(BaseUiState())
    val uiState = _uiState.asStateFlow()

    fun updateCurrentScreen(navController: NavController){
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        currentRoute?.let { route ->
            val screen = Screen.fromRoute(route)
            _uiState.update { prev ->
                prev.copy(
                    currentScreen = screen,
                    showBottomSheet = screen in screensShowBotSheet
                )
            }
        }
    }
}