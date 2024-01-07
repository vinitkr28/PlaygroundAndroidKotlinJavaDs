package cheezy_code.jetpack_compose_advance.tweetsy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cheezy_code.jetpack_compose_advance.tweetsy.viewmodels.DetailViewModel

@Composable
fun DetailScreen(category: String) {
//    val detailViewModel: DetailViewModel = viewModel()
    val detailViewModel: DetailViewModel = hiltViewModel()
    val tweets = detailViewModel.tweets.collectAsState()
    LazyColumn(content = {
        items(tweets.value.size) {
            TweetListItem(tweet = tweets.value[it].text)
        }
    })

}

@Composable
fun TweetListItem(tweet: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC))
    ) {
        Text(
            text = tweet,
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewTweetListItem() {
    TweetListItem(tweet = "Android Tweet")
}