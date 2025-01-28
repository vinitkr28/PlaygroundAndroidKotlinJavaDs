package land_of_coding.jetpack_compose.compose_side_effects.remember_updated_state

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds


@Composable
fun Timeout(buttonColor: String) {
    Log.d("test", "Composing timer with color : $buttonColor")

    /*LaunchedEffect(key1 = null) {
        delay(10.seconds)

        Log.d("test", "Timeout ended")
        Log.d("test", "Last passed button color $buttonColor")

    }*/

    val buttonColorUpdated by rememberUpdatedState(newValue = buttonColor)

    LaunchedEffect(key1 = null) {
        delay(10.seconds)

        Log.d("test", "Timeout ended")
        Log.d("test", "Last passed button color $buttonColorUpdated")

    }
}