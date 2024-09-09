package land_of_code.jetpack_compose.news_app.domain.model

import com.google.gson.annotations.SerializedName


data class Article(

    /*@SerializedName("source") var source: Source? = Source(),
    @SerializedName("author") var author: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("urlToImage") var urlToImage: String? = null,
    @SerializedName("publishedAt") var publishedAt: String? = null,
    @SerializedName("content") var content: String? = null*/


    @SerializedName("source") var source: Source,
    @SerializedName("author") var author: String? = null,
    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String? = null,
    @SerializedName("url") var url: String,
    @SerializedName("urlToImage") var urlToImage: String? = null,
    @SerializedName("publishedAt") var publishedAt: String,
    @SerializedName("content") var content: String? = null

)