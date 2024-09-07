package nativemobileappbits.app1.data.entity

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    /*@SerializedName("status") var status: String? = null,
    @SerializedName("totalResults") var totalResults: Int? = null,
    @SerializedName("articles") var articles: ArrayList<Articles> = arrayListOf()*/


    @SerializedName("status") var status: String,
    @SerializedName("totalResults") var totalResults: Int,
    @SerializedName("articles") var articles: List<Article>
)
