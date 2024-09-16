package land_of_coding.jetpack_compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme

class SecondActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            LandOfCodingJetpackComposeTheme {

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "LandOfCode")
                            },
                            colors = TopAppBarColors(
                                containerColor = Color.Green,
                                actionIconContentColor = Color.Magenta,
                                navigationIconContentColor = Color.Red,
                                titleContentColor = Color.White,
                                scrolledContainerColor = Color.Blue
                            )
                        )
                    },
                    bottomBar = {
                        BottomAppBar (
                            actions = {
                                IconButton(onClick = { /*TODO*/ }) {
                                 Icon(Icons.Filled.Check, contentDescription = "Localized description")
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(Icons.Filled.Edit, contentDescription = "Localized description")
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(Icons.Filled.Notifications, contentDescription = "Localized description")
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(Icons.Filled.AccountCircle, contentDescription = "Localized description")
                                }
                            },
                            floatingActionButton = {
                                FloatingActionButton(
                                    onClick = { /*TODO*/ },
                                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
                                    content = {
                                        Icon(Icons.Filled.Add, contentDescription = null)
                                    }
                                )
                            },
                            
                        )
                    },
                    content = {

                    }
                )
                TextCompose()
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TextCompose() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val focusRequester = remember { FocusRequester() }
        Text(
            modifier = Modifier
                .basicMarquee(animationMode = MarqueeAnimationMode.Immediately)
                .focusRequester(focusRequester)
                .focusable()
                .clickable { focusRequester.requestFocus() },
            text = "Compose has finally added support for Marquee! It's soo easy to implement!"
        )

        Text(
            text = "LineThrough",
            color = Color.Magenta,
            fontSize = 32.sp,
            textDecoration = TextDecoration.LineThrough
        )

        Text(
            text = "Underline",
            color = Color.Red,
            fontSize = 32.sp,
            textDecoration = TextDecoration.Underline
        )

        Text(
            text = stringResource(id = R.string.land_of_coding)
                .plus("")
                .repeat(20),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )

    }
}

@Preview(name = "in_light", showSystemUi = true, showBackground = true)
@Preview(
    name = "in_dark",
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun TextComposePreview() {
    LandOfCodingJetpackComposeTheme {
        TextCompose()
    }
}