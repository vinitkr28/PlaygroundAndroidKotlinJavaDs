package land_of_code.jetpack_compose.news_app.presentation.details

import land_of_code.jetpack_compose.news_app.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect: DetailsEvent()
}