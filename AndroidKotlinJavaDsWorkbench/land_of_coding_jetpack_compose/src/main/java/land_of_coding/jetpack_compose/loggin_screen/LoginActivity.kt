package land_of_coding.jetpack_compose.loggin_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import land_of_coding.jetpack_compose.loggin_screen.ui.theme.LandOfCodingJetpackComposeLoginScreenTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LandOfCodingJetpackComposeLoginScreenTheme {
                LoginScreen()
            }
        }
    }
}
