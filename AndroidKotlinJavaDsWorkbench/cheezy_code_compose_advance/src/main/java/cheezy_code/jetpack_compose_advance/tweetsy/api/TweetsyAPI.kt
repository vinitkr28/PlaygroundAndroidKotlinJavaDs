package cheezy_code.jetpack_compose_advance.tweetsy.api

import cheezy_code.jetpack_compose_advance.tweetsy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {

    @GET("/v3/b/6596f77f266cfc3fde727bb0?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String) : Response<List<TweetListItem>>

    @GET("/v3/b/6596f77f266cfc3fde727bb0?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategory(): Response<List<String>>
}