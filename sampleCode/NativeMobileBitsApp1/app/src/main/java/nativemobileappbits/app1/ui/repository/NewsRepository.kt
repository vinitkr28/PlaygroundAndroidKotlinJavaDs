package nativemobileappbits.app1.ui.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import nativemobileappbits.app1.data.datasource.NewsDataSources
import nativemobileappbits.app1.data.entity.NewsResponse
import nativemobilebits.utilities.ResourceState
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSources: NewsDataSources
) {
    /*suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return newsDataSources.getNewsHeadlineByCountry(country)
    }*/

    suspend fun getNewsHeadline(country: String) : Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSources.getNewsHeadlineByCountry(country)

            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error(response.errorBody()!!.string()))
            }
        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "Some error in the flow."))
        }
    }

    suspend fun getNewsEverything() : Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSources.getNewsEverything()

            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error(response.errorBody()!!.string()))
            }
        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "Some error in the flow."))
        }
    }
}