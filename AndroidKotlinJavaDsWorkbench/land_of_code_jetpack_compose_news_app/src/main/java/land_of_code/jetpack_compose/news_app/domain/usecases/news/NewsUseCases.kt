package land_of_code.jetpack_compose.news_app.domain.usecases.news

data class NewsUseCases(
    val getNews: GetNews,

    val searchNews: SearchNews,

    val upsertArticle: UpsertArticle,

    val deleteArticle: DeleteArticle,

    val selectArticle: SelectArticle,
)
