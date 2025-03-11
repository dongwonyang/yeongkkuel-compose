package project.compose.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import project.compose.presentation.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {

    // get bottomSheetState
    val bottomSheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.PartiallyExpanded,
        skipHiddenState = true,
        confirmValueChange = { newValue -> newValue != SheetValue.Hidden }
    )

    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState)

    // get bottomSheetPeekHeight
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val screenHeight = configuration.screenHeightDp.dp
    var imageHeight by remember { mutableStateOf(0.dp) }

    val sheetPeekHeight = screenHeight - imageHeight + 40.dp

    BottomSheetScaffold(
        sheetContent = {
            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()) {
                Text("Example bottom sheet content")
            }
        },
        scaffoldState = scaffoldState,
        sheetPeekHeight = sheetPeekHeight,
        containerColor = colorResource(R.color.black0),
        sheetSwipeEnabled = true,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.img_home_bg),
                contentDescription = "home_background",
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                    imageHeight = with(density) { coordinates.size.height.toDp() }
                }
            )
        }
    }
}


@Preview
@Composable
fun PrevHomeView() {
    HomeView(navController = rememberNavController())
}
