package cheezy_code.jetpack_compose_advance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cheezy_code.jetpack_compose_advance.tweetsy.screens.CategoryScreen
import cheezy_code.jetpack_compose_advance.tweetsy.screens.DetailScreen
import cheezy_code.jetpack_compose_advance.ui.theme.ComposeWorkbeanchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TweetsyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWorkbeanchTheme {
                TweetsyApp()
            }
        }
    }
}

@Composable
fun TweetsyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable(route = "category") {
            CategoryScreen {
                navController.navigate("detail/$it")
            }
        }
        composable(route = "detail/{category}", arguments = listOf(
            navArgument("category") {
                type = NavType.StringType
            }
        )) {

            it.arguments?.getString("category")?.let { it1 -> DetailScreen(it1) }
        }
    }
}

