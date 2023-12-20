package cheezyCode.jetpackCompose.workbeanchTwo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.sp
import cheezyCode.jetpackCompose.R

class WorkbeanchTwoLayoutCompose {
}

@Composable
fun SampleLayoutColumnOne() {
    Column {
        Text(
            text = "Sample Text one",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            fontSize = 36.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Two",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            fontSize = 36.sp,
            textAlign = TextAlign.Center
        )
    }

}

@Preview(
    name = "ColumnOne",
    device = Devices.DEFAULT,
    showSystemUi = true,
    showBackground = true,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE
)
@Composable
fun PreviewSampleLayoutOne() {
    SampleLayoutColumnOne()
}

@Composable
fun SampleLayoutColumnTwo() {
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        Text(
            text = "Sample Text one",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            fontSize = 36.sp
        )
        Text(
            text = "Two",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            fontSize = 36.sp
        )
    }

}

@Preview(
    name = "ColumnTwo",
    device = Devices.DEFAULT,
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PreviewSampleLayoutColumnTwo() {
    SampleLayoutColumnTwo()
}

@Composable
fun LayoutColumnThree(value1: String, value2: String) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value1,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            fontSize = 36.sp
        )
        Text(
            text = value2,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            fontSize = 36.sp
        )
    }

}

@Preview(
    name = "ColumnTwo",
    device = Devices.DEFAULT,
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PreviewLayoutColumnThree() {
    LayoutColumnThree("one", "Two")
}


@Composable
fun LayoutRowOne(value1: String, value2: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = value1,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            fontSize = 36.sp
        )
        Text(
            text = value2,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            fontSize = 36.sp
        )
    }

}

@Preview(
    name = "RowOne",
    device = Devices.DEFAULT,
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PreviewLayoutRowOne() {
    LayoutRowOne("one", "Two")
}


@Composable
fun LayoutBoxOne(value1: String, value2: String) {
    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.heart_svgrepo_com),
            contentDescription = "Image 1",
            contentScale = ContentScale.Inside
        )
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher_foreground),
            contentDescription = "Image 2"
        )
    }

}

@Preview(
    name = "LayoutBoxOne",
    device = Devices.DEFAULT,
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PreviewLayoutBoxOne() {
    LayoutBoxOne("one", "Two")
}