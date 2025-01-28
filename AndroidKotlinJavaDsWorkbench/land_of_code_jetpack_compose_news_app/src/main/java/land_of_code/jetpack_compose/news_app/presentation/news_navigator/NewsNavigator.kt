package land_of_code.jetpack_compose.news_app.presentation.news_navigator

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import land_of_code.jetpack_compose.news_app.domain.model.Article
import land_of_code.jetpack_compose.news_app.presentation.bookmark.BookMarkViewModel
import land_of_code.jetpack_compose.news_app.presentation.bookmark.BookmarkScreen
import land_of_code.jetpack_compose.news_app.presentation.details.DetailViewModel
import land_of_code.jetpack_compose.news_app.presentation.details.DetailsEvent
import land_of_code.jetpack_compose.news_app.presentation.details.DetailsScreen
import land_of_code.jetpack_compose.news_app.presentation.home.HomeScreen
import land_of_code.jetpack_compose.news_app.presentation.home.HomeViewModel
import land_of_code.jetpack_compose.news_app.presentation.navgraph.Route
import land_of_code.jetpack_compose.news_app.presentation.news_navigator.components.NewsBottomNavigation
import land_of_code.jetpack_compose.news_app.presentation.search.SearchScreen
import land_of_code.jetpack_compose.news_app.presentation.search.SearchViewModel
import land_of_code.jetpack_compose.news_app.util.Constants

@Composable
fun NewsNavigator() {
    val bottomNavigationItems = remember {
        Constants.navigationBottomItems.map { it.copy() }
    }

    val navController = rememberNavController()

    val backstackState = navController.currentBackStackEntryAsState().value

    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }

    selectedItem = remember(key1 = backstackState) {
        when (backstackState?.destination?.route) {
            Route.HomeScreen.route -> 0
            Route.SearchScreen.route -> 1
            Route.BookmarkScreen.route -> 2
            else -> 0
        }
    }

    val isBottomBarVisible = remember(key1 = backstackState) {
        backstackState?.destination?.route == Route.HomeScreen.route ||
                backstackState?.destination?.route == Route.SearchScreen.route ||
                backstackState?.destination?.route == Route.BookmarkScreen.route
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                NewsBottomNavigation(
                    items = bottomNavigationItems,
                    selected = 0,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTap(
                                navController = navController, route = Route.HomeScreen.route
                            )

                            1 -> navigateToTap(
                                navController = navController, route = Route.SearchScreen.route
                            )

                            2 -> navigateToTap(
                                navController = navController, route = Route.BookmarkScreen.route
                            )
                        }
                    }
                )
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) {
                val viewModel: HomeViewModel = hiltViewModel()
                val article = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(
                    articles = article, navigateToSearch = {
                        navigateToTap(
                            navController = navController, route = Route.SearchScreen.route
                        )
                    }, navigateToDetails = { article ->
                        navigateToDetails(
                            navController = navController, article = article
                        )
                    }
                )
            }

            composable(route = Route.SearchScreen.route) {
                val viewModel: SearchViewModel = hiltViewModel()
                val state = viewModel.state.value
                SearchScreen(
                    state = state,
                    event = viewModel::onEvent,
                    navigateToDetails = { article ->
                        navigateToDetails(
                            navController = navController, article = article
                        )
                    }
                )
            }

            composable(route = Route.DetailsScreen.route) {
                val viewModel: DetailViewModel = hiltViewModel()

                if (viewModel.sideEffect != null) {
                    Toast.makeText(LocalContext.current, viewModel.sideEffect, Toast.LENGTH_SHORT).show()
                    viewModel.onEvent(DetailsEvent.RemoveSideEffect)
                }
                navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")
                    ?.let {
                        DetailsScreen(
                            article = it,
                            event = viewModel::onEvent,
                            navigateUp = { navController.navigateUp() })
                    }
            }

            composable(route = Route.BookmarkScreen.route) {
                val viewModel: BookMarkViewModel = hiltViewModel()
                val state = viewModel.state.value

                BookmarkScreen(
                    state = state, navigateToDetails = {
                        navigateToDetails(navController = navController, article = it)
                    }
                )
            }
        }
    }
}

private fun navigateToTap(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}

private fun navigateToDetails(navController: NavController, article: Article) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(
        route = Route.DetailsScreen.route
    )
}