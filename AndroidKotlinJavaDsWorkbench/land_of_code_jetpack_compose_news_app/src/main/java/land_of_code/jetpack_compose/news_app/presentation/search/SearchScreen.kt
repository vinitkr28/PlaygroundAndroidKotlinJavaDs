package land_of_code.jetpack_compose.news_app.presentation.search

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import land_of_code.jetpack_compose.news_app.presentation.Dimens
import land_of_code.jetpack_compose.news_app.presentation.common.ArticleList
import land_of_code.jetpack_compose.news_app.presentation.common.SearchBar
import land_of_code.jetpack_compose.news_app.presentation.navgraph.Route
import land_of_code.jetpack_compose.news_app.ui.theme.LandOfCodeNewsAppTheme

//https://github.com/lofcoding/NewsApp/blob/part10-Details/app/src/main/java/com/loc/newsapp/presentation/search/SearchScreen.kt

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigate: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(
                top = Dimens.MediumPadding1,
                start = Dimens.MediumPadding1,
                end = Dimens.MediumPadding1
            )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { event(SearchEvent.SearchNews) }
        )

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticleList(articles = articles) {
                navigate(Route.DetailsScreen.route)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SearchScreenPreview() {
    LandOfCodeNewsAppTheme {
        val viewModel: SearchViewModel = hiltViewModel()
        SearchScreen(state = viewModel.state.value, event = { viewModel::onEvent }, navigate = {})
    }
}

