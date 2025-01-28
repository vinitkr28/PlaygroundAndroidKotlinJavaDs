package land_of_coding.jetpack_compose.loggin_screen_all_screen_size

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.LandOfCodingJetpackComposeLoginScreenAllScreenTheme

class LoginAllScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LandOfCodingJetpackComposeLoginScreenAllScreenTheme {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "DDDDDDDD", style = TextStyle.Default)
                }
                LoginScreenAllScreen()
            }
        }
    }
}
