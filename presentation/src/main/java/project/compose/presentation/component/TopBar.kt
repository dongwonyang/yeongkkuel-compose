package project.compose.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import project.compose.presentation.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onMoreClick: (() -> Unit)? = null,
    onBellClick: (() -> Unit)? = null
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        navigationIcon = {
            Image(
                modifier = Modifier.height(24.dp).aspectRatio(1.0F),
                painter = painterResource(id = R.drawable.img_logo),
                contentDescription = "logo"
            )
        },
        title = {},
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(R.drawable.ic_bell),
                    contentDescription = "More options",
                    tint = colorResource(id = R.color.main1)
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.ic_more),
                    contentDescription = "More options",
                    tint = colorResource(id = R.color.main1)
                )
            }
        }
    )
}

@Preview
@Composable
fun PrevTopBar(){
    TopBar()
}