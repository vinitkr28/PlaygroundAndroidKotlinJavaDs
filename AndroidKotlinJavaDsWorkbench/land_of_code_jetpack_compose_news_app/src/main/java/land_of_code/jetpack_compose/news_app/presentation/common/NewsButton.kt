package land_of_code.jetpack_compose.news_app.presentation.common

import android.content.res.Configuration
import android.widget.Button
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import land_of_code.jetpack_compose.news_app.ui.theme.LandOfCodeNewsAppTheme

@Composable
fun NewsButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 6.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}

@Composable
fun NewsTextButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = if (isSystemInDarkTheme()) Color.White else Color.Black
        )
    }
}


@Preview(name = "NewsButtonPreview", device = Devices.PIXEL_6_PRO, showSystemUi = true)
@Composable
private fun NewsButtonPreview() {
    LandOfCodeNewsAppTheme {
        NewsButton(text = "Next") {
            
        }
    }
}

@Preview(name = "NewsTextButton", device = Devices.PIXEL_6_PRO, showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun NewsTextButtonPreview() {
    LandOfCodeNewsAppTheme {
        NewsTextButton(text = "Get Started") {

        }
    }
}