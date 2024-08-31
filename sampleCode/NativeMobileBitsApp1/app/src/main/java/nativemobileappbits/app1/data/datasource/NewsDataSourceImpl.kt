package nativemobileappbits.app1.data.datasource

import nativemobileappbits.app1.data.api.ApiService
import nativemobileappbits.app1.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSources {
    override suspend fun getNewsHeadlineByCountry(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadlineByCountry(country)
    }
}