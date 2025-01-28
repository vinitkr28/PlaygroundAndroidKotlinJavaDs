package land_of_code.jetpack_compose.news_app.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import land_of_code.jetpack_compose.news_app.domain.usecases.news.NewsUseCases
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    val news = newsUseCases.getNews(
//        sources = listOf("bbc-news", "abc-news", "al-jazeera-english")
        sources = listOf("google-news-in", "the-hindu", "the-times-of-india")
    ).cachedIn(viewModelScope)
}