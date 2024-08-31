package land_of_code.jetpack_compose.news_app.presentation.onboarding.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import land_of_code.jetpack_compose.news_app.R
import land_of_code.jetpack_compose.news_app.presentation.Dimens.MediumPadding1
import land_of_code.jetpack_compose.news_app.presentation.Dimens.MediumPadding2
import land_of_code.jetpack_compose.news_app.presentation.onboarding.Page
import land_of_code.jetpack_compose.news_app.presentation.onboarding.pages
import land_of_code.jetpack_compose.news_app.ui.theme.LandOfCodeNewsAppTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(
                id = R.color.display_small
            )
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(
                id = R.color.text_medium
            )
        )
    }
}

@Preview(
    name = "light_pixel",
    device = Devices.PIXEL_6_PRO,
    showSystemUi = true,
    showBackground = true
)
@Preview(
    name = "dark_pixel",
    device = Devices.PIXEL_6_PRO,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun OnBoardingPagePreview() {
    LandOfCodeNewsAppTheme {
        OnBoardingPage(
            page = pages[0]
        )
    }
}