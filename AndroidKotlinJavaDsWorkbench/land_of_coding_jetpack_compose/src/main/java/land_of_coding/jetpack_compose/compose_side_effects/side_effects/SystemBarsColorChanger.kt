package land_of_coding.jetpack_compose.compose_side_effects.side_effects

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

@Composable
fun SystemBarsColorChanger(
    statusBarColor: Color?,
    navigationBarColors: Color?
) {
    val window = (LocalContext.current as Activity).window

    //When you want to change non compose state inside a composable function and the way you want to change that state is not supported by digit composed apis
    SideEffect {
        statusBarColor?.let {
            window.statusBarColor = it.toArgb()
        }

        navigationBarColors?.let {
            window.navigationBarColor = it.toArgb()
        }
    }
}