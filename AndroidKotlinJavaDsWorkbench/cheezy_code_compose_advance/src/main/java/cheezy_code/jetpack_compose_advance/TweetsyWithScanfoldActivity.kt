package cheezy_code.jetpack_compose_advance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
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
class TweetsyWithScanfoldActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWorkbeanchTheme {

                Scaffold(topBar = {
                    TopAppBar(title = { Text(text = "Tweetsy", textDecoration = TextDecoration.Underline) },
                        modifier = Modifier.background(Color.Black),
                        navigationIcon = {

                        },
                        actions = {

                        })
                }) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        TweetsyWithScanfoldApp()
                    }
                }


                /*Scaffold() { paddingValues ->
                    // rest of the app's UI
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues = paddingValues),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Rest of the app UI")
                    }
                }*/
            }
        }
    }
}


@Composable
fun TweetsyWithScanfoldApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable(route = "category") {
            CategoryScreen {
                navController.navigate("detail/$it")
            }
        }
        composable(route = "detail/{category}", arguments = listOf(navArgument("category") {
            type = NavType.StringType
        })) {

            it.arguments?.getString("category")?.let { it1 -> DetailScreen(it1) }
        }
    }
}

