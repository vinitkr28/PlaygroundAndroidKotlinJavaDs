package land_of_code.jetpack_compose.news_app.data.remote.dto

import com.google.gson.annotations.SerializedName
import land_of_code.jetpack_compose.news_app.domain.model.Article

data class NewsResponse(
    /*@SerializedName("status") var status: String? = null,
    @SerializedName("totalResults") var totalResults: Int? = null,
    @SerializedName("articles") var articles: ArrayList<Articles> = arrayListOf()*/


    @SerializedName("status") var status: String,
    @SerializedName("totalResults") var totalResults: Int,
    @SerializedName("articles") var articles: List<Article>
)
