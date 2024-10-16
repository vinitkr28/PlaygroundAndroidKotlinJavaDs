package cheezy_code.jetpack_compose_advance.tweetsy.repository

import cheezy_code.jetpack_compose_advance.tweetsy.api.TweetsyAPI
import cheezy_code.jetpack_compose_advance.tweetsy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetAPI: TweetsyAPI) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories


    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>>
        get() = _tweets


    suspend fun getCategories() {
        val  response = tweetAPI.getCategory()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!.distinct())
        }
    }


    suspend fun getTweets(category: String) {
        val makeHeader = "tweets[?(@.category==\"$category\")]"
        val  result = tweetAPI.getTweets(makeHeader)
        if (result.isSuccessful && result.body() != null) {
            _tweets.emit(result.body()!!)
        }
    }
}