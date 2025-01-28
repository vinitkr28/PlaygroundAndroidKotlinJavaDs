package land_of_coding.jetpack_compose.compose_examples

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScaffoldExample()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample(modifier: Modifier = Modifier) {
    LandOfCodingJetpackComposeTheme {
        val snackBarHost = remember {
            SnackbarHostState()
        }

        val scope = rememberCoroutineScope()

        var text by remember {
            mutableStateOf("")
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
//                        Box(modifier = Modifier.fillMaxWidth().height(150.dp).background(Color.Red)) {}

                TopAppBar(
                    title = {
                        Text(text = "LandOfCoding")
                    },
                    modifier = Modifier.shadow(10.dp)
                )
            },
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = true,
                        onClick = { },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.AcUnit,
                                contentDescription = ""
                            )
                        }
                    )

                    NavigationBarItem(
                        selected = false,
                        onClick = { },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.AccountBalance,
                                contentDescription = ""
                            )
                        }
                    )
                }
            },
            snackbarHost = {
                SnackbarHost(hostState = snackBarHost)
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(onClick = {
                    scope.launch {
                        snackBarHost.showSnackbar(text)
                    }
                }
                ) {
                    Text(text = "Show snackbar")
                }
            },
            floatingActionButtonPosition = FabPosition.End
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
//                    .padding(paddingValues)
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding()
                    )
                    .background(Color.Green)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(color = Color.Red, width = 2.dp, shape = RectangleShape)
                        .clip(shape = RectangleShape),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Hello")

                    TextField(value = text, onValueChange = {
                        text = it
                    })

                }
            }
        }
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
    ScaffoldExample()
}