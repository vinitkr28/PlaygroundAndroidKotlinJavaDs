package cheezyCode.jetpackCompose.workbenchTwo

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cheezyCode.jetpackCompose.R

class WorkbenchTwoImageCompose {
}



@Composable
fun SampleImageOne() {
    Image(
        painter = painterResource(id = R.drawable.heart_svgrepo_com),
        contentDescription = "Dummy Image",
        contentScale = ContentScale.Fit
    )
}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun PreviewSampleImageOne() {
    SampleImageOne()
}


@Composable
fun SampleImageTwo() {
    Image(
        painter = painterResource(id = R.drawable.heart_svgrepo_com),
        contentDescription = "Dummy Image",
        colorFilter = ColorFilter.tint(Color.Red),
        contentScale = ContentScale.FillBounds
    )
}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun PreviewSampleImageTwo() {
    SampleImageTwo()
}


