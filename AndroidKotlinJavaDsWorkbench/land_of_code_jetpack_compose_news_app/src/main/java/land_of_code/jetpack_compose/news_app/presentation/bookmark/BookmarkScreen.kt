package land_of_code.jetpack_compose.news_app.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import land_of_code.jetpack_compose.news_app.R
import land_of_code.jetpack_compose.news_app.presentation.Dimens.ExtraSmallPadding
import land_of_code.jetpack_compose.news_app.presentation.Dimens.MediumPadding1
import land_of_code.jetpack_compose.news_app.presentation.common.ArticleList
import land_of_code.jetpack_compose.news_app.presentation.navgraph.Route

@Composable
fun BookmarkScreen(
    state: BookmarkState, navigate: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
//            .padding(
//                top = MediumPadding1,
//                start = MediumPadding1,
//                end = MediumPadding1
//            )
            .padding(
                top = MediumPadding1,
                start = ExtraSmallPadding,
                end = MediumPadding1
            )
    ) {
        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_title)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        ArticleList(
//            modifier = Modifier
//                .padding(
//                    top = MediumPadding1,
//                    start = MediumPadding1,
//                    end = MediumPadding1
//                ),
            articles = state.articles
        ) {
            navigate(Route.DetailsScreen.route)
        }
    }
}