package land_of_code.jetpack_compose.news_app.domain.usecases.news

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import land_of_code.jetpack_compose.news_app.domain.model.Article
import land_of_code.jetpack_compose.news_app.domain.repository.NewsRepository

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}