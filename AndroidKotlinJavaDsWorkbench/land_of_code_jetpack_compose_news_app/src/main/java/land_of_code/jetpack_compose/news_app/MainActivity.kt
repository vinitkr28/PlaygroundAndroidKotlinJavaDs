package land_of_code.jetpack_compose.news_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import land_of_code.jetpack_compose.news_app.presentation.onboarding.OnBoardingScreen
import land_of_code.jetpack_compose.news_app.presentation.onboarding.components.OnBoardingPage
import land_of_code.jetpack_compose.news_app.presentation.onboarding.pages
import land_of_code.jetpack_compose.news_app.ui.theme.LandOfCodeNewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            LandOfCodeNewsAppTheme {
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OnBoardingScreen()
                }*/

                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    OnBoardingScreen()
                }
            }
        }
    }
}
