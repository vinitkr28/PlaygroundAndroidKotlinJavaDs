package land_of_code.jetpack_compose.news_app.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import land_of_code.jetpack_compose.news_app.domain.model.Article

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM news_articles")
//    @Query("SELECT * FROM Article")
    fun getArticles() : Flow<List<Article>>

    @Query("SELECT * FROM news_articles WHERE id=:id")
    suspend fun getArticle(id: Int) : Article?
}