package land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val BlackAllScreen = Color(0xFF000113)
val LightBlueWhiteAllScreen = Color(0xFFF1F5F9) //Social media background
val BlueGrayAllScreen = Color(0xFF334155)


val ColorScheme.focusedTextFieldTextAllScreen
    @Composable
    get() = if (isSystemInDarkTheme()) Color.White else Color.Black


val ColorScheme.unfocusedTextFieldTextAllScreen
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF94A3B8) else Color(0xFF475569)


val ColorScheme.textFieldContainerAllScreen
    @Composable
    get() = if (isSystemInDarkTheme()) BlueGrayAllScreen.copy(alpha = 0.6f) else LightBlueWhiteAllScreen