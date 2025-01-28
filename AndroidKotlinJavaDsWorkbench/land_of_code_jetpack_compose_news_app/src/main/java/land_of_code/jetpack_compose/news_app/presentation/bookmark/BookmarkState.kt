package land_of_code.jetpack_compose.news_app.presentation.bookmark

import land_of_code.jetpack_compose.news_app.domain.model.Article

data class BookmarkState (
    val articles: List<Article> = emptyList()
)