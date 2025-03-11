package project.compose.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import project.compose.presentation.R
import project.compose.presentation.navigation.Navigation
import project.compose.presentation.navigation.screensInBot
import project.compose.presentation.utils.navigateBottom

@Composable
fun BottomBar(navController: NavController) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.White
    ) {
        val currentRoute =
            navController.currentBackStackEntryAsState().value?.destination?.route


        screensInBot.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.bRoute,
                onClick = {
                    navController.navigateBottom(screen)
                },
                icon = {
                    Icon(
                        painter = painterResource(screen.bIcon),
                        contentDescription = screen.route
                    )
                },
                label = {
                    Text(text = screen.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(R.color.main1),
                    unselectedIconColor = colorResource(R.color.black_nav),
                    selectedTextColor = Color.Black,
                    unselectedTextColor = Color.Black,
                    indicatorColor = Color.Transparent
                ),
            )
        }

    }
}

@Preview
@Composable
fun PrevBottomBar(){
    BottomBar(navController = rememberNavController())
}