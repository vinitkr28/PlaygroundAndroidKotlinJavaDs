package land_of_code.jetpack_compose.news_app.presentation.details

sealed class DetailsEvent {
    object SaveArticle : DetailsEvent()
}