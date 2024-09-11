package land_of_code.jetpack_compose.news_app.presentation.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import land_of_code.jetpack_compose.news_app.domain.usecases.news.NewsUseCases
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    private val _state = mutableStateOf(BookmarkState())
    val state: State<BookmarkState> = _state

    init {
        getArticles()
    }

    private fun getArticles() {
        newsUseCases.selectArticles().onEach { articles ->
//            _state.value = _state.value.copy(articles = articles)
            _state.value = _state.value.copy(articles = articles.asReversed())
        }.launchIn(viewModelScope)
    }

}