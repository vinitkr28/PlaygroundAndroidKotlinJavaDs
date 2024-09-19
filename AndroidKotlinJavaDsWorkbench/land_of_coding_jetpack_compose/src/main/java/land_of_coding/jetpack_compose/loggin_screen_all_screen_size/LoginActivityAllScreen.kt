package land_of_coding.jetpack_compose.loggin_screen_all_screen_size

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.LandOfCodingJetpackComposeLoginScreenAllScreenTheme

class LoginActivityAllScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LandOfCodingJetpackComposeLoginScreenAllScreenTheme {
                LoginScreenAllScreen()
            }
        }
    }
}
