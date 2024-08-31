package nativemobileappbits.app1.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import nativemobileappbits.app1.data.AppConstants
import nativemobileappbits.app1.data.entity.NewsResponse
import nativemobileappbits.app1.ui.repository.NewsRepository
import nativemobilebits.utilities.ResourceState
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news: MutableStateFlow<ResourceState<NewsResponse>> =
        MutableStateFlow(ResourceState.Loading())

    val news: StateFlow<ResourceState<NewsResponse>> = _news

    init {
        Log.d(TAG, "Init block of NewsViewModel")

        getNews(AppConstants.COUNTRY)
    }

    private fun getNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadline(country)
                .collectLatest { newsRepository ->
                    _news.value = newsRepository
                }
        }
    }



    companion object {
        const val TAG = "NewsViewModel"
    }
}