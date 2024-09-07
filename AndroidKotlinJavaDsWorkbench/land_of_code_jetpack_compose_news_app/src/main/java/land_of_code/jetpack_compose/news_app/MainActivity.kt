package land_of_code.jetpack_compose.news_app

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import land_of_code.jetpack_compose.news_app.domain.usecases.AppEntryUseCases
import land_of_code.jetpack_compose.news_app.presentation.onboarding.OnBoardingScreen
import land_of_code.jetpack_compose.news_app.ui.theme.LandOfCodeNewsAppTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Tell the system to fit the window content below system bars (like status bar)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        installSplashScreen()
        enableEdgeToEdge()

        //https://stackoverflow.com/questions/74429460/how-to-implement-transparent-status-bar-in-jetpack-compose-android
//        https://developer.android.com/develop/ui/compose/layouts/insets
        /*
        WindowInsetsControllerCompat(window, window.decorView).apply {
            hide(WindowInsetsCompat.Type.statusBars())
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.attributes.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }
        */


        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect{
                Log.d("Test", "onCreate: $it")
            }
        }
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

