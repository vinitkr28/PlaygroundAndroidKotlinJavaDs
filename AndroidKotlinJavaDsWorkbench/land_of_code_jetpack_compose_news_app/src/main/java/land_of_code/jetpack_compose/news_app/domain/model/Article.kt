package land_of_code.jetpack_compose.news_app.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


//@Entity(tableName = "news_articles", primaryKeys = ["id", "title"])
@Entity(tableName = "news_articles")
//@Entity
data class Article(

    /*@SerializedName("source") var source: Source? = Source(),
    @SerializedName("author") var author: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("urlToImage") var urlToImage: String? = null,
    @SerializedName("publishedAt") var publishedAt: String? = null,
    @SerializedName("content") var content: String? = null*/



    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "source")
    @SerializedName("source")
    var source: Source,

    @ColumnInfo(name = "author")
    @SerializedName("author")
    var author: String? = null,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String? = null,

    @ColumnInfo(name = "url")
    @SerializedName("url")
    var url: String,

    @ColumnInfo(name = "url_to_image")
    @SerializedName("urlToImage")
    var urlToImage: String? = null,

    @ColumnInfo(name = "published_at")
    @SerializedName("publishedAt")
    var publishedAt: String,

    @ColumnInfo(name = "content")
    @SerializedName("content")
    var content: String? = null
)