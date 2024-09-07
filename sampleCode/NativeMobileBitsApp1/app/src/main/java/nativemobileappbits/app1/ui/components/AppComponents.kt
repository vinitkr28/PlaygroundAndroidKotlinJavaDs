package nativemobileappbits.app1.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nativemobileappbits.app1.R
import nativemobileappbits.app1.data.entity.Article
import nativemobileappbits.app1.data.entity.NewsResponse
import nativemobileappbits.app1.data.entity.Source
import nativemobileappbits.app1.ui.theme.Purple40

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(100.dp)
                .padding(10.dp),
            color = Purple40
        )
    }
}

@Composable
fun NewsList(response: NewsResponse, page: Int) {
    LazyColumn {
        items(response.articles) { eachArticle ->
            NormalTextComponent(textValue = eachArticle.title ?: "NA")
        }
    }
}

@Composable
fun NormalTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Monospace,
//            color = Purple40
        )
    )
}

@Composable
fun HeadingTextComponent(textValue: String, centerAlignment: Boolean = false) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        ),
        textAlign = if (centerAlignment) TextAlign.Center else TextAlign.Start
    )
}

@Composable
fun AuthorDetailsComponent(authorName: String?, sourceName: String?) {
    Row(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 24.dp)
    ) {
        authorName?.also {
//            NormalTextComponent(textValue = it)
            Text(text = it, color = Color.Red)
        }

        sourceName?.also {
//            NormalTextComponent(textValue = it)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = it, color = Color.Blue)
        }
    }
}

@Composable
fun NewsRowComponent(page: Int, article: Article) {
//    NormalTextComponent(textValue = "$page \n\n ${article.title}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.Yellow)
    ) {
        AsyncImage(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(8.dp)
                )
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
//                .wrapContentHeight(),
                .height(240.dp),
            model = article.urlToImage,
            contentDescription = "",
//            contentScale = ContentScale.Crop
            contentScale = ContentScale.FillBounds,
            placeholder = painterResource(id = R.drawable.splash_screen1),
            error = painterResource(id = R.drawable.ic_launcher_background)
        )

        Spacer(modifier = Modifier.size(20.dp))

//        NormalTextComponent(textValue = article.title ?: "")
        HeadingTextComponent(textValue = article.title ?: "")

        Spacer(modifier = Modifier.size(10.dp))

        NormalTextComponent(textValue = article.description ?: "")

//        Spacer(modifier = Modifier.size(10.dp))
        Spacer(modifier = Modifier.weight(1f))

        AuthorDetailsComponent(
            authorName = article.author,
            sourceName = article.source.name
        )
    }
}

@Preview(name = "NewsRowComponentPreview", showSystemUi = true, showBackground = true)
@Composable
private fun NewsRowComponentPreview() {

    val source = Source(id = "google-news", name = "Google News")
    val article = Article(
        author = "Yahoo Finance",
        content = null,
        url = "https://news.google.com/rss/articles/CBMixwFBVV95cUxQRW1aemFCN1daeGVPS2pMeWt3djJLWjIwUmU4dC0yZWhIR0Z3X2NXM0lDV0VYMjFOX3JoY2Q1QS0zVE5IYVpmNnhqS1JXQ0ltS3Q1aGMtcTV6cFZBVWUxa2w3R0E0S0hZaXluM0tDMjlqTkxHT3lnbHA4QTVGSGQzRVMweTJWWjAzTE1FZTBNQ091ajFBbGhUNE9HWVlqNmI1T3JIQ2ctem51Z1hBNC1nc2hJcHpLaVNJREFHM2luUERfWDZONDE0?oc=5",
        urlToImage = "https://news.google.com/rss/articles/CBMixwFBVV95cUxQRW1aemFCN1daeGVPS2pMeWt3djJLWjIwUmU4dC0yZWhIR0Z3X2NXM0lDV0VYMjFOX3JoY2Q1QS0zVE5IYVpmNnhqS1JXQ0ltS3Q1aGMtcTV6cFZBVWUxa2w3R0E0S0hZaXluM0tDMjlqTkxHT3lnbHA4QTVGSGQzRVMweTJWWjAzTE1FZTBNQ091ajFBbGhUNE9HWVlqNmI1T3JIQ2ctem51Z1hBNC1nc2hJcHpLaVNJREFHM2luUERfWDZONDE0?oc=5",
        description = null,
        publishedAt = "2024-08-30T13:34:18Z",
        title = "Stock market today: US stocks rise as Fed-favored PCE inflation print hits the mark - Yahoo Finance",
        source = source
    )
    NewsRowComponent(page = 0, article = article)
}

@Composable
fun EmptyStateComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
//            .background(Color.DarkGray)
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.page_not_load_error),
            contentDescription = "",
            contentScale = ContentScale.Fit
        )

//        Box(modifier = Modifier.fillMaxWidth(), Alignment.Center) {
            Text(
                text = "No News as of now.",
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Magenta)
            )
            Text(
                text = "Please check in some time!",
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Red)
            )
//        }

        HeadingTextComponent(textValue = "Not able to get the response\nPlease check the connection.", centerAlignment = true)
    }
}

@Preview(name = "EmptyStateComponentPreview", showSystemUi = true, showBackground = true)
@Composable
private fun EmptyStateComponentPreview() {
    EmptyStateComponent()
}