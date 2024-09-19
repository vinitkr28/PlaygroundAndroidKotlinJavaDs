package land_of_coding.jetpack_compose.compose_examples

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Deblur
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme


/*
*
* https://developer.android.com/develop/ui/compose/components/app-bars
* https://medium.com/@myofficework000/bottom-appbar-with-jetpack-compose-59795808eae4
*
* */

class AppBarExampleActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            LandOfCodingJetpackComposeTheme {

//                MediumTopAppBarExample()

//                SmallTopAppBarExample()

//                CenterAlignedTopAppBarExample()

                LargeTopAppBarExample { innerPadding ->
                    Box {
                        ScrollContent(innerPadding)
//                        Sample1(innerPadding = innerPadding)
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBarExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Small Top App Bar")
                }
            )
        },
    ) { innerPadding ->
        ScrollContent(innerPadding)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopAppBarExample() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Centered Top App Bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        ScrollContent(innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumTopAppBarExample() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Medium Top App Bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = { BottomAppBarImpl() }
    ) { innerPadding ->
        ScrollContent(innerPadding)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeTopAppBarExample(content: @Composable (PaddingValues) -> Unit) {
    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .background(color = Transparent),
        topBar = {
            LargeTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Large Top App Bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = { BottomAppBarImpl() },
        containerColor = Transparent,
    ) { innerPadding ->
        content(innerPadding)
    }
}

@Composable
fun BottomAppBarExample() {
    Scaffold(
        bottomBar = { BottomAppBarImpl() },
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = "Example of a scaffold with a bottom app bar."
        )
    }
}

@Composable
fun BottomNavigationImpl(modifier: Modifier = Modifier) {
//    BottomNavi
}


@Composable
fun BottomAppBarImpl() {
    BottomAppBar(
//        modifier = Modifier
//            .background(color = Transparent),
        contentColor = Color.Green,
        containerColor = Transparent,
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(Icons.Filled.Check, contentDescription = "Localized description")
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.Deblur,
                    contentDescription = "Localized description",
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.FormatQuote,
                    contentDescription = "Localized description",
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.Build,
                    contentDescription = "Localized description",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Apps, "Localized description")
            }
        }
    )
}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    LazyColumnSample1(paddingValues = innerPadding)
}

@Composable
fun LazyColumnSample1(
    ctx: Context = LocalContext.current.applicationContext,
    paddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
            .background(Color.DarkGray)
    ) {
        items(count = 53) { columnIndex ->
            Row {
                repeat(10) { rowIndex ->

                    val text =
                        if (columnIndex > 26) {
                            "${(65 + 6 + columnIndex - 1).toChar()}$rowIndex"
                        } else {
                            "${(65 + columnIndex).toChar()}$rowIndex"
                        }

                    Box(
                        modifier = Modifier
                            .border(color = Red, width = 1.dp, shape = RoundedCornerShape(4.dp))
                            .padding(10.dp)
                            .size(50.dp)

                            .padding(2.dp)
                            .border(width = 1.dp, color = Green, shape = RoundedCornerShape(8.dp))
                            .clip(shape = RoundedCornerShape(8.dp))
//                            .padding(2.dp)
//                            .border(color = Green, width = 1.dp, shape = RoundedCornerShape(4.dp))
                            .wrapContentHeight()
                            .background(Color.Yellow)
                            .clickable {
                                Toast
                                    .makeText(ctx, text, Toast.LENGTH_SHORT)
                                    .show()
                            }
                    ) {
                        Text(
                            text = text,
                            textAlign = TextAlign.Center, // make text center horizontal
                            modifier = Modifier
                                .size(50.dp)
                                .padding(2.dp)
//                                .background(Color.Cyan)
                                .wrapContentHeight() // make text center vertical
                        )
                    }


                    /*Column(modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .clickable(onClick = { } ) *//*question = "3 Bananas required"*//*
                        .clip(shape = RoundedCornerShape(16.dp)),
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(50.dp)
                                .background(color = Color.Yellow)
                        ) {
                            Text(
                                text = "A",
                                modifier = Modifier.padding(16.dp),
                                textAlign = TextAlign.Center,
                                style = typography.bodyMedium,
                            )
                            //...
                        }
                    }*/


                    /*Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(50.dp)
                            .background(color = Color.Yellow),
                        contentAlignment = Alignment.Center,
                        content = {
                            Text(
                                modifier = Modifier
                                    .fillMaxSize(),
//                                    .background(Color.Red),
                                text = "A",
                                textAlign = TextAlign.Center
                            )
                        }
                    )*/
                }
            }
        }
    }
}

@Composable
fun LazyColumnSample2(innerPadding: PaddingValues) {

    Box(
        modifier = Modifier.padding(innerPadding)
    ) {
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(100) { index ->
                Text(text = "$index")
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(name = "in_light", showSystemUi = true, showBackground = true)
//@Preview(name = "in_dark", showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SmallTopAppBarExamplePreview() {
    LandOfCodingJetpackComposeTheme {
        SmallTopAppBarExample()
    }
}

@Preview(name = "in_light", showSystemUi = true, showBackground = true)
//@Preview(name = "in_dark", showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CenterAlignedTopAppBarExamplePreview() {
    LandOfCodingJetpackComposeTheme {
        CenterAlignedTopAppBarExample()
    }
}

@Preview(name = "in_light", showSystemUi = true, showBackground = true)
//@Preview(name = "in_dark", showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TextComposePreview() {
    LandOfCodingJetpackComposeTheme {
        MediumTopAppBarExample()
    }
}

@Preview(name = "in_light", showSystemUi = true, showBackground = true)
//@Preview(name = "in_dark", showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LargeTopAppBarExamplePreview() {
    LandOfCodingJetpackComposeTheme {
        LargeTopAppBarExample {}
    }
}

@Preview(name = "in_light", showSystemUi = true, showBackground = true)
//@Preview(name = "in_dark", showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BottomAppBarExamplePreview() {
    LandOfCodingJetpackComposeTheme {
        BottomAppBarExample()
    }
}

@Preview(name = "in_light", showSystemUi = true, showBackground = true)
//@Preview(name = "in_dark", showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ExamplePreview() {
    LandOfCodingJetpackComposeTheme {
        /*Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                // .height(300.dp)

                .clip(shape = RoundedCornerShape(20.dp))
                .padding(10.dp)
//                .border(BorderStroke(2.dp, SolidColor(Green)))
                .background(Color(0xFF7DCEA0), shape = RoundedCornerShape(15.dp))
                .border(BorderStroke(2.dp, SolidColor(Red)))

        ) {
            Text(text = "ddfdfdf")
        }*/

        /*Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                // .height(300.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFF7DCEA0), shape = RoundedCornerShape(20.dp))
                .border(BorderStroke(2.dp, SolidColor(Color.Red))),
        ){
            Text("one")
            Text("two")
        }*/

        Sample1(innerPadding = null)

    }
}

@Composable
fun Sample1(innerPadding: PaddingValues?, modifier: Modifier = Modifier) {
    var pointerOffset by remember {
        mutableStateOf(Offset(0f, 0f))
    }

    val paddingValue: PaddingValues = innerPadding ?: PaddingValues(6.dp)
    Column(
        modifier = Modifier
            .padding(paddingValue)
            .fillMaxSize()
            .pointerInput("dragging") {
                detectDragGestures { change, dragAmount ->
                    pointerOffset += dragAmount
                }
            }
            .onSizeChanged {
                pointerOffset = Offset(it.width / 2f, it.height / 2f)
            }
            .drawWithContent {
                drawContent()
                // draws a fully black area with a small keyhole at pointerOffset that’ll show part of the UI.
                drawRect(
                    Brush.radialGradient(
                        listOf(Color.Transparent, Color.Black),
                        center = pointerOffset,
                        radius = 100.dp.toPx(),
                    )
                )
            }
    ) {
        // Your composables here
    }
}

