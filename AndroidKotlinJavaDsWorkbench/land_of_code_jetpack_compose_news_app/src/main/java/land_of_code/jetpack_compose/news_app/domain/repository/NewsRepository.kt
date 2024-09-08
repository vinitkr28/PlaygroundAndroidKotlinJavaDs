package land_of_code.jetpack_compose.news_app.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import land_of_code.jetpack_compose.news_app.domain.model.Article

interface NewsRepository {

    fun getNews(sources: List<String>) : Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String>) : Flow<PagingData<Article>>
}