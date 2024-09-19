package land_of_coding.jetpack_compose.loggin_screen_all_screen_size

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.BlueGrayAllScreen
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.LightBlueWhiteAllScreen
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.dimens

@Composable
fun SocialMediaLoginAllScreen(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    text: String,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .socialMediaAllScreen()
            .clickable { onClick() }
            .height(MaterialTheme.dimens.buttonHeight),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = icon),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF64748B))
        )
    }
}


@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.socialMediaAllScreen(): Modifier = composed {
    if (isSystemInDarkTheme()) {
        background(Color.Transparent).border(
            width = 1.dp,
            color = BlueGrayAllScreen,
            shape = RoundedCornerShape(4.dp)
        )
    } else {
        background(LightBlueWhiteAllScreen)
    }
}