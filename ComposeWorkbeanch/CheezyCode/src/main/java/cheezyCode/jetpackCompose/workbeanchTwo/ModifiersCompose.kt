package cheezyCode.jetpackCompose.workbeanchTwo

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cheezyCode.jetpackCompose.R

class ModifiersCompose {
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun PreviewFunction() {
    Text(
        text = "Helo",
        modifier = Modifier
//            .size(300.dp)
            .border(color = Color.Red, width = 4.dp)
            .background(Color.Blue)
            .size(300.dp)
//            .wrapContentHeight(align = Alignment.CenterVertically)
            .padding(20.dp)
            .border(color = Color.White, width = 4.dp)
            .clip(CircleShape)
            .background(Color.Yellow),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline,
    )

}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun Texttwo() {
    Text(
        text = "Example",
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .background(color = Color.Cyan)
            .wrapContentHeight(align = Alignment.CenterVertically),
        color = Color.Black,
        fontSize = 42.sp,
        textAlign = TextAlign.Right
    )
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun Test() {
    Text(
        text = "Hello world",
        modifier = Modifier
            .border(2.dp, Color.Red)
            .size(200.dp)
            .layout { measurable, constraints ->
                val placeable =
                    measurable.measure(
                        // This is how wrapContent works
                        constraints.copy(minWidth = 0, minHeight = 0)
                    )
                layout(constraints.maxWidth, constraints.maxHeight) {
                    // This is how wrapContent alignment works
                    val x = (constraints.maxWidth - placeable.width) / 2
                    val y = (constraints.maxHeight - placeable.height) / 2
                    placeable.placeRelative(x, y)
                }
            },
        textAlign = TextAlign.Center
    )
}


@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun Test2() {

    val body = TextStyle(
        fontSize = 16.sp,
        lineHeight = 22.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Proportional,
            trim = LineHeightStyle.Trim.None
        )
    )


    Text(
        text = "With TextStyle", style = body,
        modifier = Modifier
            .border(2.dp, Color.Red)
            .size(200.dp)
            .layout { measurable, constraints ->
                val placeable =
                    measurable.measure(
                        // This is how wrapContent works
                        constraints.copy(minWidth = 0, minHeight = 0)
                    )
                layout(constraints.maxWidth, constraints.maxHeight) {
                    // This is how wrapContent alignment works
                    val x = (constraints.maxWidth - placeable.width) / 2
                    val y = (constraints.maxHeight - placeable.height) / 2
                    placeable.placeRelative(x, y)
                }
            },
        textAlign = TextAlign.Center
    )
}


@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun Test3() {

    Text(
        text = "Helo",
        modifier = Modifier
//            .size(300.dp)
            .border(color = Color.Red, width = 4.dp)
            .background(Color.Blue)
            .size(300.dp)
//            .wrapContentHeight(align = Alignment.CenterVertically)
            .padding(20.dp)
            .border(color = Color.White, width = 4.dp)
            .clip(CircleShape)
            .background(Color.Yellow)
            .clickable {
                Log.d("ModifiersCompose", "Test3: ")
            }
            .fillMaxSize(.8f),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline,
    )
}


@Composable
fun CircularImage() {
    Image(
        painter = painterResource(id = R.drawable.signify_1),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Red, CircleShape)
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4,
    backgroundColor = 0x0065AF,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    name = "Preview1"
)
@Preview(
    showBackground = true, showSystemUi = true, device = Devices.PIXEL_4,
    backgroundColor = 0xFFF3C47F, name = "Preview2"
)
@Composable
private fun PreviewCircularImage() {
    CircularImage()
}



