package nativemobileappbits.app1.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nativemobileappbits.app1.ui.viewmodel.NewsViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import nativemobileappbits.app1.ui.components.EmptyStateComponent
import nativemobileappbits.app1.ui.components.Loader
import nativemobileappbits.app1.ui.components.NewsRowComponent
import nativemobilebits.utilities.ResourceState

private const val TAG = "HomeScreen"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsRes by newsViewModel.news.collectAsState()


    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100
    }
    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 16.dp
    ) { page: Int ->
        when (newsRes) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Inside_Loading: ")
                Loader()
            }

            is ResourceState.Error -> {
                val error = (newsRes as ResourceState.Error).error
                Log.d(TAG, "Inside_Error: $error")
                EmptyStateComponent()
            }

            is ResourceState.Success -> {
                val response = (newsRes as ResourceState.Success).data
                Log.d(
                    TAG,
                    "Inside_Success:*********(START)\nStatus:\t\t\t${response.status}\nTotalResults:\t${response.totalResults}\nArticles:\t\t${response.articles}\nInside_Success:*********(END)"
                )
//                NewsList(response, page)
                if (response.articles.isNotEmpty())
                    NewsRowComponent(page, response.articles.get(page))
            }

            else -> {}
        }
    }
}

@Preview(name = "HomeScreen", showSystemUi = true, device = Devices.PIXEL_7_PRO)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}