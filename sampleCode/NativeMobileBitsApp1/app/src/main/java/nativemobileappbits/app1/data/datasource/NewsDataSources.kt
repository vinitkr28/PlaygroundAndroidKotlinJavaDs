package nativemobileappbits.app1.data.datasource

import nativemobileappbits.app1.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSources {

    suspend fun getNewsHeadlineByCountry(country:String): Response<NewsResponse>

    suspend fun getNewsEverything(): Response<NewsResponse>
}