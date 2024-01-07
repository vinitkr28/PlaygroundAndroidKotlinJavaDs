package cheezy_code.cheezy_code_compose_advance.tweetsy.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cheezy_code.cheezy_code_compose_advance.tweetsy.models.TweetListItem
import cheezy_code.cheezy_code_compose_advance.tweetsy.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: TweetRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var category = savedStateHandle.get<String>("category") ?: "android"

    val tweets: StateFlow<List<TweetListItem>>
        get() = repository.tweets

    init {
        viewModelScope.launch {
//            repository.getTweets("android")
            repository.getTweets(category)
        }
    }
}