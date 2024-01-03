package cheezy_code.jetpack_compose.workbenchTwo

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers

private const val TAG = "WorkbenchTwoTextFieldC"

class WorkbenchTwoTextFieldCompose {
}

@Composable
fun SampleTextFieldOne() {
    TextField(
        value = "Hello Vinit",
        onValueChange = {
            Log.d(TAG, "SampleTextFieldOne: $it")
        },
        label = {
            Text(text = "Enter Message")
        },
        placeholder = {
            Text(text = "placeholder")
        }
    )
}


@Preview(
    name = "Sample Text One",
    device = Devices.DEFAULT,
    showSystemUi = true,
    showBackground = true,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE
)
@Composable
fun PreviewSampleTextFieldOne() {
    SampleTextFieldOne()
}

@Composable
fun SampleTextFieldTwo() {
    val state = remember {
        mutableStateOf("")
    }

    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
            Log.d(TAG, "SampleTextFieldOne: $it")
        },
        label = {
            Text(text = "Enter Message")
        },
        placeholder = {
            Text(text = "placeholder")
        }
    )
}