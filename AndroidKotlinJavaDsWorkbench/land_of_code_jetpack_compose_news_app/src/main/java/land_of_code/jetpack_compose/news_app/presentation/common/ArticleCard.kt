package land_of_code.jetpack_compose.news_app.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import land_of_code.jetpack_compose.news_app.R
import land_of_code.jetpack_compose.news_app.domain.model.Article
import land_of_code.jetpack_compose.news_app.domain.model.Source
import land_of_code.jetpack_compose.news_app.presentation.Dimens.ArticleCardSize
import land_of_code.jetpack_compose.news_app.presentation.Dimens.ExtraSmallPadding
import land_of_code.jetpack_compose.news_app.presentation.Dimens.ExtraSmallPadding2
import land_of_code.jetpack_compose.news_app.presentation.Dimens.SmallIconSize
import land_of_code.jetpack_compose.news_app.ui.theme.LandOfCodeNewsAppTheme
import land_of_code.jetpack_compose.news_app.util.ConstantsPreview

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier, article: Article, onClick: () -> Unit
) {
    val context = LocalContext.current

    Row(modifier = modifier.clickable { onClick() }) {
        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .background(Color.Transparent)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = article.source.name ?: "",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ArticleCardPreview() {
    LandOfCodeNewsAppTheme {
        Box(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
        ) {
            ArticleCard(article = ConstantsPreview.articlePreviewInputType1) {}
        }
    }
}