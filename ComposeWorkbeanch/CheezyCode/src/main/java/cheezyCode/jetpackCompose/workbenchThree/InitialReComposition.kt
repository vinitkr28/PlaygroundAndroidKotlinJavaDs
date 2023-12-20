package cheezyCode.jetpackCompose.workbenchThree

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview


private const val TAG = "InitialReComposition"
class InitialReComposition {
}

@Composable
fun TextInputComposeWithState() {
    val state = remember {
        mutableStateOf("")
    }
    TextField(value = state.value, onValueChange = {
        state.value = it

    })
}

//Intelligent Recomposition

@Preview(device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun PreviewTextInputComposeWithState() {
    TextInputComposeWithState()
}


@Composable
fun ButtonRow() {
    /*MyFancyNavigation {
        StartScreen()
        MiddleScreen()
        EndScreen()
    }*/

    //Here there is no guarantee that it will execute in same order.
    // we don't have control on sequence of execution of these compose function

    //RECOMPOSITION
    //1. Recomposition skips as many composable functions and lambdas as possible.
    //2. Recomposition is optimistic and may be canceled.
    // [optimistic: suppose current compose function is executing and before completion the
    // state is changed then it will cancel the execution and will recompose with the new set of data.]
    //3. A composable function might be run quite frequently, as often as every frame of an animation
    //https://developer.android.com/jetpack/compose/mental-model
}


@Composable
fun Recomposable() {
    val state = remember {
        mutableStateOf(0.0)
    }

    val stateSaveInBundle = rememberSaveable {
//        mutableStateOf(0)
        mutableIntStateOf(0)
    }
    Log.d(TAG, "Logged during Initial Composition")

    Button(
        onClick = {
            state.value = Math.random()
        }
    ) {
        Log.d(TAG, "Logged during both Composition & Recomposition")
        Text(text = state.value.toString())
    }
}
