package land_of_code.jetpack_compose.news_app.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import land_of_code.jetpack_compose.news_app.data.remote.NewsApi
import land_of_code.jetpack_compose.news_app.data.remote.NewsPagingSource
import land_of_code.jetpack_compose.news_app.data.remote.SearchNewsPagingSource
import land_of_code.jetpack_compose.news_app.domain.model.Article
import land_of_code.jetpack_compose.news_app.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}