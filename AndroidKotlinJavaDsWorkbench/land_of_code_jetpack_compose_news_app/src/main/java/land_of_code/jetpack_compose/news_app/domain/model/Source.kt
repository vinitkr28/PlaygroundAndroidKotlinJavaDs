package land_of_code.jetpack_compose.news_app.domain.model

import com.google.gson.annotations.SerializedName


data class Source(

    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null

)