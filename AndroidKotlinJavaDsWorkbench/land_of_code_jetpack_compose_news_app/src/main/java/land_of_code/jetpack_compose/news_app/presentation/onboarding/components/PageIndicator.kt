package land_of_code.jetpack_compose.news_app.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import land_of_code.jetpack_compose.news_app.presentation.Dimens.IndicatorSize
import land_of_code.jetpack_compose.news_app.presentation.common.NewsButton
import land_of_code.jetpack_compose.news_app.ui.theme.BlueGray
import land_of_code.jetpack_compose.news_app.ui.theme.LandOfCodeNewsAppTheme

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = BlueGray
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier
                    .size(IndicatorSize)
                    .clip(CircleShape)
                    .background(color = if (page == selectedPage) selectedColor else unselectedColor)
            )
        }
    }
}


@Preview(name = "NewsButtonPreview", device = Devices.PIXEL_6_PRO, showSystemUi = true)
@Composable
private fun NewsButtonPreview() {
    PageIndicator(pageSize = 3, selectedPage = 1)
}