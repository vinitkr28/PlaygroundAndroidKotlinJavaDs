package land_of_code.jetpack_compose.news_app.presentation.search

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import land_of_code.jetpack_compose.news_app.domain.model.Article

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)