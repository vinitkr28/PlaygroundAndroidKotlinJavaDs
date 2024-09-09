package land_of_code.jetpack_compose.news_app.domain.usecases.news

import kotlinx.coroutines.flow.Flow
import land_of_code.jetpack_compose.news_app.data.local.NewsDao
import land_of_code.jetpack_compose.news_app.domain.model.Article

class SelectArticle(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}