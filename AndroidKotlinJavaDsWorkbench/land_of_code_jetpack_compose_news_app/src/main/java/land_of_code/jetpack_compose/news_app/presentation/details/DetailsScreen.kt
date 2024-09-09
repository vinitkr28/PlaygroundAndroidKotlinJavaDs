package land_of_code.jetpack_compose.news_app.presentation.details

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import land_of_code.jetpack_compose.news_app.R
import land_of_code.jetpack_compose.news_app.domain.model.Article
import land_of_code.jetpack_compose.news_app.domain.model.Source
import land_of_code.jetpack_compose.news_app.presentation.Dimens.ArticleImageHeight
import land_of_code.jetpack_compose.news_app.presentation.Dimens.MediumPadding1
import land_of_code.jetpack_compose.news_app.presentation.details.components.DetailsTopBar
import land_of_code.jetpack_compose.news_app.ui.theme.LandOfCodeNewsAppTheme

@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailsTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(article.url)

                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"

                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onBookmarkClick = {
                event(DetailsEvent.SaveArticle)
            },
            onBackClick = {
                navigateUp
            }
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1
            )
        ) {
            item {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                    model = ImageRequest.Builder(context = context).data(article.urlToImage)
                        .build(), contentDescription = null
                )

                Spacer(modifier = Modifier.height(MediumPadding1))

                Text(
                    text = article.title,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(id = R.color.body)
                )

                Spacer(modifier = Modifier.height(MediumPadding1))

                Text(
                    text = article.content ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DetailsScreenPreview() {
    LandOfCodeNewsAppTheme {
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            val article = Article(
                author = "NYT News Service",
                content = "One Saturday evening in late July, more than 100 people attended an elaborate party in the lush garden of a mansion in Silicon Valley. The host was David Wei, a former CEO of Alibaba, the Chinese e-c… [+6800 chars]",
                description = "With China's economy in a lasting slump, investors and entrepreneurs are seeking the next China. They feel unwelcome by their government, which in recent years has sent an ominous message by clamping down on private companies. The heightened tensions between …",
                publishedAt = "2024-09-07T13:28:01Z",
                source = Source(id = "the-times-of-india", name = "The Times of India"),
                title = "Chinese tech investors struggle for a toehold in Silicon Valley",
                url = "https://economictimes.indiatimes.com/tech/technology/chinese-tech-investors-struggle-for-a-toehold-in-silicon-valley/articleshow/113153221.cms",
                urlToImage = "https://img.etimg.com/thumb/msid-113153226,width-1200,height-630,imgsize-129990,overlay-ettech/photo.jpg"
            )
            DetailsScreen(article = article, event = {}, navigateUp = {})
        }
    }
}