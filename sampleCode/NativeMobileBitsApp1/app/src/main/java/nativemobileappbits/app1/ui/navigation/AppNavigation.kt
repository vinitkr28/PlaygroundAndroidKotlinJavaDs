package nativemobileappbits.app1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nativemobileappbits.app1.ui.screens.HomeScreen
import nativemobilebits.app1.ui.navigation.Routes

@Composable
fun AppNavigationGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {

        composable(Routes.HOME_SCREEN) {
            HomeScreen()
        }
    }
}