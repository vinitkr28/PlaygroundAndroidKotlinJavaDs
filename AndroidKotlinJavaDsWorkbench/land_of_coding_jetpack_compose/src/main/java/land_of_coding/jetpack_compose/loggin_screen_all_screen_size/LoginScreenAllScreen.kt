package land_of_coding.jetpack_compose.loggin_screen_all_screen_size

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import land_of_coding.jetpack_compose.R
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.BlackAllScreen
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.BlueGrayAllScreen
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.LandOfCodingJetpackComposeLoginScreenAllScreenTheme
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.RobotoAllScreen
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.ScreenOrientation
import land_of_coding.jetpack_compose.loggin_screen_all_screen_size.ui.theme.dimens

@Composable
fun LoginScreenAllScreen(modifier: Modifier = Modifier) {
    Surface {
        if (ScreenOrientation == Configuration.ORIENTATION_PORTRAIT)
            PortraitLoginScreen()
        else
            LandscapeLoginScreen()

    }
}

@Composable
private fun LandscapeLoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.Center
    ) {
        LoginScreenAllScreen()
        SocialMediaSection()
    }
}

@Composable
private fun PortraitLoginScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopSection()

        Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium2))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {

            LoginSection()
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium1))

            SocialMediaSection()

            CreateAccountLink()
        }
    }
}

@Composable
private fun CreateAccountLink() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else BlackAllScreen
    Box(
        modifier = Modifier
            .fillMaxHeight(fraction = 0.8f)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF94A3B8),
                        fontSize = MaterialTheme.typography.labelMedium.fontSize,
                        fontFamily = RobotoAllScreen,
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append("Don't have account?")
                }

                withStyle(
                    style = SpanStyle(
                        color = uiColor,
                        fontSize = MaterialTheme.typography.labelMedium.fontSize,
                        fontFamily = RobotoAllScreen,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append(" ")
                    append("Create Now")
                }
            }
        )
    }
}

@Composable
private fun SocialMediaSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Or continue with",
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF64748B))
        )

        Spacer(modifier = Modifier.height(MaterialTheme.dimens.small2))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialMediaLoginAllScreen(
                icon = R.drawable.google,
                text = "Google",
                modifier = Modifier.weight(1f)
            ) {

            }

            Spacer(modifier = Modifier.width(20.dp))

            SocialMediaLoginAllScreen(
                icon = R.drawable.facebook,
                text = "Facebook",
                modifier = Modifier.weight(1f)
            ) {

            }
        }
    }
}

@Composable
private fun LoginSection() {
    LoginTextField(
        label = "Email",
        trailing = "",
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small2))

    LoginTextField(
        label = "Password",
        trailing = "",
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small3))

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.dimens.buttonHeight),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) BlueGrayAllScreen else BlackAllScreen,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = "Login in",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else BlackAllScreen

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
//                .fillMaxHeight(fraction = 0.5f),
                .fillMaxHeight(fraction = 0.46f),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )


        Row(
            modifier = Modifier.padding(MaterialTheme.dimens.large),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(MaterialTheme.dimens.logoSize),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.app_logo),
                tint = uiColor
            )

            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Text(
                    text = stringResource(id = R.string.the_tolet),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor
                )

                Text(
                    text = stringResource(id = R.string.find_house),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColor
                )
            }


        }

        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.BottomCenter),
            text = stringResource(id = R.string.text_login),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor
        )
    }
}


@Preview(
    name = "in_light",
    showSystemUi = true,
    showBackground = true,
    device = Devices.PIXEL_7_PRO
)
@Preview(
    name = "in_dark",
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    device = Devices.PIXEL_7_PRO
)
@Composable
private fun LoginScreenPreview() {
    LandOfCodingJetpackComposeLoginScreenAllScreenTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
//                .background(colorResource(id = R.color.black).copy(alpha = 0.9f)),
            contentAlignment = Alignment.Center,
        ) {
            LoginScreenAllScreen()
        }
    }
}