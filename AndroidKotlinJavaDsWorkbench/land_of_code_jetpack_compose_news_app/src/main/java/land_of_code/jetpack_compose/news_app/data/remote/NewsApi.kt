package land_of_code.jetpack_compose.news_app.data.remote

import land_of_code.jetpack_compose.news_app.data.remote.dto.NewsResponse
import land_of_code.jetpack_compose.news_app.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse


    @GET("v2/everything")
    suspend fun getNewsEverything(
        @Query("q") q: String = "tesla",
        @Query("from") from: String = "2024-07-31",
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = "59c09252879c46eea3f3428f38169168"
    ): Response<NewsResponse>

    //    https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY
    @GET("v2/top-headlines")
    suspend fun getNewsHeadlineByCountry(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "59c09252879c46eea3f3428f38169168"
    ): Response<NewsResponse>
}