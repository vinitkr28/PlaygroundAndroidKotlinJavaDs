package land_of_code.jetpack_compose.news_app.domain.usecases.news

import land_of_code.jetpack_compose.news_app.data.local.NewsDao
import land_of_code.jetpack_compose.news_app.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article) {
        newsDao.upsert(article)
    }
}