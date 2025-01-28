package land_of_coding.jetpack_compose.compose_side_effects.launched_effect

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme
import kotlin.time.Duration.Companion.seconds

@Composable
fun CounterExample(
    max: Int,
    onCounterChange: (Int) -> Unit
) {
    var counter by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(key1 = counter) {
        /*for (i in 0..max) {
            delay(1.seconds)
            onCounterChange(counter)
            counter++
        }*/

        if (counter >= max + 1) {
            return@LaunchedEffect
        }
        delay(1.seconds)
        onCounterChange(counter)
        counter++
    }
}


@Composable
fun SideEffectsLaunchEffectExample(modifier: Modifier = Modifier) {
    LandOfCodingJetpackComposeTheme {

        var text by remember {
            mutableStateOf("")
        }

        LaunchedEffect(key1 = Unit) {
            delay(2.seconds)
        }

        LaunchedEffect(key1 = text, key2 = Unit, key3 = Unit) {
            delay(2.seconds)
        }
    }
}


@Preview(name = "in_light", showSystemUi = true, showBackground = true)
@Preview(
    name = "in_dark",
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun TextComposePreview() {
    SideEffectsLaunchEffectExample()
}