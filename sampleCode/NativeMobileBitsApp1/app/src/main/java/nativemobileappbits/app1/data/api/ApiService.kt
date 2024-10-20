package nativemobileappbits.app1.data.api

import nativemobileappbits.app1.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //https://newsapi.org/v2/everything?q=tesla&from=2024-07-31&sortBy=publishedAt&apiKey=59c09252879c46eea3f3428f38169168

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