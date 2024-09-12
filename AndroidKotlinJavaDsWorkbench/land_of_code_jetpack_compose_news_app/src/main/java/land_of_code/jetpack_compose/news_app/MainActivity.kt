package land_of_code.jetpack_compose.news_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import land_of_code.jetpack_compose.news_app.data.local.NewsDao
import land_of_code.jetpack_compose.news_app.presentation.common.EmptyScreen
import land_of_code.jetpack_compose.news_app.presentation.navgraph.NavGraph
import land_of_code.jetpack_compose.news_app.ui.theme.LandOfCodeNewsAppTheme
import land_of_code.jetpack_compose.news_app.util.ConstantsPreview
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var appEntryUseCases: AppEntryUseCases

    val viewModel by viewModels<MainViewModel>()

//    @Inject
//    lateinit var newsDao: NewsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Tell the system to fit the window content below system bars (like status bar)
        WindowCompat.setDecorFitsSystemWindows(window, true)

//        lifecycleScope.launch { newsDao.upsert(ConstantsPreview.articlePreviewInputType1) }

        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }
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


        /*
        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect{
                Log.d("Test", "onCreate: $it")
            }
        }
        */

        setContent {
            LandOfCodeNewsAppTheme {
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OnBoardingScreen()
                }*/


                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemController = rememberSystemUiController()

                SideEffect {
                    systemController.setSystemBarsColor(
                        color = Color.Transparent,
//                        color = Color.Red,
                        darkIcons = !isSystemInDarkMode
                    )
                }

                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    /*val viewModel: OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(
                        event = viewModel::onEvent
//                        event = { viewModel.onEvent(it) }
                    )*/

                    //above line will go to navHost

                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
}

