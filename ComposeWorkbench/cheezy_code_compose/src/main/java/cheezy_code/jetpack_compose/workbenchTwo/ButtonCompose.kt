package cheezy_code.jetpack_compose.workbenchTwo

import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cheezy_code.jetpack_compose.R

class WorkbenchTwoButtonCompose {
}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun PreviewSampleButton() {
    SampleButton()
}


@Composable
fun SampleButton() {
    Button(
        onClick = { }, colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Blue
        ), enabled = false
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Dummy"
        )
        Text(text = "Hello")
    }
}