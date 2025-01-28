package land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun ProvideAppUtils(
    appDimens: Dimens,
    content: @Composable () -> Unit
) {
    val appDimens = remember {
        appDimens
    }

    CompositionLocalProvider(value = LocalAppDimens provides appDimens) {

    }
}

val LocalAppDimens = compositionLocalOf {
    CompactDimens
}

val ScreenOrientation
    @Composable
    get() = LocalConfiguration.current.orientation