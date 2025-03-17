package project.compose.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import project.compose.presentation.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    val viewModel: HomeViewModel = viewModel()
    val uiState = viewModel.uiState.collectAsState()

    // get bottomSheetState
    val bottomSheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.PartiallyExpanded,
        skipHiddenState = true,
        confirmValueChange = { newValue -> newValue != SheetValue.Hidden }
    )

    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState)

    // get bottomSheetPeekHeight
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val screenHeight = configuration.screenHeightDp.dp
    val topNavHeight = with(density) {
        context.resources.getDimension(R.dimen.top_nav_total_height).toDp()
    }
    var imageHeight by remember { mutableStateOf(0.dp) }
    var imageWidth by remember { mutableStateOf(0.dp) }

    val sheetPeekHeight by remember { derivedStateOf { screenHeight - imageHeight - topNavHeight } }

    BottomSheetScaffold(
        sheetContent = {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize()
            ) {
                Text(formatDate(uiState.value.date))
            }
        },
        scaffoldState = scaffoldState,
        sheetPeekHeight = sheetPeekHeight,
        containerColor = colorResource(R.color.black0),
        sheetSwipeEnabled = true,
        modifier = Modifier.fillMaxSize(),
        sheetDragHandle = {}
    ) {
        val imageSizeModifier = Modifier
            .height(imageHeight / 2)
            .width(imageWidth / 2)

        Column {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                // 배경 이미지
                Image(
                    painter = painterResource(R.drawable.img_home_bg),
                    contentDescription = "home_background",
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            imageHeight = with(density) { coordinates.size.height.toDp() }
                            imageWidth = with(density) { coordinates.size.width.toDp() }
                        }
                )

                Column {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(R.drawable.img_1),
                            contentDescription = "image1",
                            modifier = imageSizeModifier,
                        )

                        Image(
                            painter = painterResource(R.drawable.img_2),
                            contentDescription = "image2",
                            modifier = imageSizeModifier,
                        )
                    }

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(R.drawable.img_3),
                            contentDescription = "image3",
                            modifier = imageSizeModifier
                        )
                        Image(
                            painter = painterResource(R.drawable.img_4),
                            contentDescription = "image4",
                            modifier = imageSizeModifier
                        )
                    }
                }

                Image(
                    painter = painterResource(R.drawable.img_bird),
                    contentDescription = "bird image",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(164.dp)
                )
            }
        }

    }
}


fun formatDate(date: Date): String {
    val locale = Locale.KOREAN // 한국어 요일 출력
    val dateFormat = SimpleDateFormat("M월 d일 E요일", locale)
    return dateFormat.format(date)
}

@Preview
@Composable
fun PrevHomeView() {
    HomeView(navController = rememberNavController())
}
