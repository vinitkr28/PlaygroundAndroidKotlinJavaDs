package land_of_coding.jetpack_compose.compose_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import land_of_coding.jetpack_compose.compose_navigation.screens.EnteredPersonDataScreen
import land_of_coding.jetpack_compose.compose_navigation.screens.PassObjectsScreen
import land_of_coding.jetpack_compose.compose_navigation.screens.ScreenA
import land_of_coding.jetpack_compose.compose_navigation.screens.ScreenB
import land_of_coding.jetpack_compose.compose_navigation.screens.ScreenC
import land_of_coding.jetpack_compose.compose_navigation.screens.ScreenD
import land_of_coding.jetpack_compose.compose_navigation.screens.ShareByViewModelScreen
import land_of_coding.jetpack_compose.compose_navigation.screens.ShareToViewModelScreen
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme


class ComposeNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LandOfCodingJetpackComposeTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "screen_a") {
                    composable(
                        route = "screen_a",
                        exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                tween(1000)
                            ) + fadeOut()
                        },

                        popEnterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Up,
                                tween(1000)
                            )
                        }
                    ) {
                        ScreenA(
                            navigateToB = {
                                navController.navigate("screen_b/$it/12")
                            },
                            navigateToPassObjectScreen = { navController.navigate("screen_pass_objects") },
                            navigateToShareWithViewModel = { navController.navigate("main") }
                        )
                    }

                    composable(
                        route = "screen_b/{text}/{id}",
                        arguments = listOf(
                            navArgument("text") {
                                type = NavType.StringType
                                nullable = true
                                defaultValue = "Unknown"
                            },

                            navArgument("id") {
                                type = NavType.IntType
                                defaultValue = 0
                            }
                        ),
                        enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Down,
                                tween(1000)
                            )
                        },
                        popExitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                tween(1000)
                            )
                        }
                    ) {
                        //text inserted into Nav back stack entry
                        /*it.arguments?.getString("text")
                            ?.let { t ->
                                ScreenB(
                                    text = t,
                                    navigateToC = {
                                        navController.navigate("screen_c")
                                    },
                                    navigateBack = {
                                        navController.popBackStack()
                                    }
                                )
                            }*/

                        it.arguments?.apply {
                            val text = getString("text")

                            val id = getInt("id")

                            ScreenB(
                                text = text ?: "",
                                id = id,
                                navigateToC = {
                                    navController.navigate("screen_c")
                                },
                                navigateBack = {
                                    navController.popBackStack()
                                }
                            )
                        }
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

                                navController.navigate("screen_a") {
                                    popUpTo(0)
                                }
                            },
                            navigateToD = { name, age ->
                                navController.navigate("screen_d?name=$name&age=$age")
                            }
                        )
                    }


                    composable(
                        route = "screen_d?name={name}&age={age}",
                        arguments = listOf(
                            navArgument("name") {
                                type = NavType.StringType
                                nullable = true
                            },
                            navArgument("age") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ) {
                        it.arguments?.apply {
                            val name = getString("name") ?: ""
                            val age = getInt("age")

                            ScreenD(
                                name = name,
                                age = age,
                                navigateBackToC = { navController.popBackStack() },
                                navigateBackToB = {
                                    navController.popBackStack()
                                    navController.popBackStack()
                                },
                                navigateBackToA = {
                                    navController.navigate("screen_a") {
                                        popUpTo(0)
                                    }
                                }
                            )
                        }
                    }


                    composable(
                        route = "screen_pass_objects",

                        ) {
                        PassObjectsScreen(
                            navigateBackToA = {
                                navController.navigate("screen_a") {
                                    popUpTo(0)
                                }
                            },
                            navigateToEnterPersonDataScreen = { person ->
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    "person",
                                    person
                                )
                                navController.navigate("display_person_data_screen")
                            }
                        )
                    }

                    composable(
                        route = "display_person_data_screen",

                        ) {
                        navController.previousBackStackEntry?.savedStateHandle?.get<Person>("person")
                            ?.let { p ->
                                EnteredPersonDataScreen(
                                    person = p,
                                    navigateBackToA = {
                                        navController.navigate("screen_a") {
                                            popUpTo(0)
                                        }
                                    },
                                    navigateBackToPassObjectScreen = {
                                        navController.popBackStack()
                                    }
                                )
                            }
                    }

                    navigation(
                        route = "main",
                        startDestination = "share_by_view_model"
                    ) {
                        composable(
                            route = "share_by_view_model",

                            ) {
                            val viewModel: SharedViewModel =
                                it.sharedViewModel(navController = navController)
                            ShareByViewModelScreen(
                                navigateToShareToViewModelScreen = {
                                    viewModel.person = it
                                    navController.navigate("share_to_view_model")
                                },
                                navigateBackToA = {
                                    navController.navigate("screen_a") {
                                        popUpTo(0)
                                    }
                                }
                            )
                        }

                        composable(
                            route = "share_to_view_model",
                        ) {
                            val viewModel: SharedViewModel =
                                it.sharedViewModel(navController = navController)
                            viewModel.person?.let { p ->
                                ShareToViewModelScreen(
                                    p,
                                    navigateBackToShareByViewModelScreen = { navController.popBackStack() },
                                    navigateBackToA = {
                                        navController.navigate("screen_a") {
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
    }
}