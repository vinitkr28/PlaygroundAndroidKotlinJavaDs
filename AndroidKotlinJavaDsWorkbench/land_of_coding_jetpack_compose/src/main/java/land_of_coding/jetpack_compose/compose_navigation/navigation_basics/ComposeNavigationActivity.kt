package land_of_coding.jetpack_compose.compose_navigation.navigation_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import land_of_coding.jetpack_compose.compose_navigation.navigation_basics.screens.ScreenA
import land_of_coding.jetpack_compose.compose_navigation.navigation_basics.screens.ScreenB
import land_of_coding.jetpack_compose.compose_navigation.navigation_basics.screens.ScreenC
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme


class ComposeNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LandOfCodingJetpackComposeTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "screen_a") {
                    composable(
                        route = "screen_a"
                    ) {
                        ScreenA(
                            navigateToB = {
                                navController.navigate("screen_b")
                            }
                        )
                    }

                    composable(
                        route = "screen_b"
                    ) {
                        ScreenB(
                            navigateToC = {
                                navController.navigate("screen_c")
                            },
                            navigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }

                    composable(
                        route = "screen_c"
                    ) {
                        ScreenC(
                            navigateBackToB = {
                                navController.popBackStack()
                            },
                            navigateBackToA = {
//                                navController.popBackStack()
//                                navController.popBackStack()

                                navController.navigate("screen_a"){
                                    popUpTo(0)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}