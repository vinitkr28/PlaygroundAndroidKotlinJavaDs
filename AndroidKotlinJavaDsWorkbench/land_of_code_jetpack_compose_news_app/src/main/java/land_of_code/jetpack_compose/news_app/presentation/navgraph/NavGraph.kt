package land_of_code.jetpack_compose.news_app.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import land_of_code.jetpack_compose.news_app.presentation.onboarding.OnBoardingScreen
import land_of_code.jetpack_compose.news_app.presentation.onboarding.OnBoardingViewModel
import land_of_code.jetpack_compose.news_app.presentation.search.SearchScreen
import land_of_code.jetpack_compose.news_app.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination:String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {

        navigation(
            route = Route.AppStartNavigation.route,
            startDestination =  Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable(
                route = Route.NewsNavigatorScreen.route
            ) {
//                Text(text = "News Navigator Screen")


                /*val viewModel: HomeViewModel = hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(articles = articles, navigate = {})*/


                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(
                    state = viewModel.state.value,
                    event = viewModel::onEvent,
//                    event = { viewModel.onEvent(it) },//we can call onEvent in this way also.
                    navigate = {}
                )
            }
        }
    }
}