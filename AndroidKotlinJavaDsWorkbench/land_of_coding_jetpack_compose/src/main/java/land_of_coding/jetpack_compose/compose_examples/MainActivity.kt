package land_of_coding.jetpack_compose.compose_examples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import land_of_coding.jetpack_compose.R
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme

class MainActivity : ComponentActivity() {
//    val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
//    val viewModel = ViewModelProvider(this)[MyViewModel::class.java]

    val viewModel by lazy {
        ViewModelProvider(this)[MyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val state = viewModel.state

            LandOfCodingJetpackComposeTheme {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Row(
                        modifier = Modifier
                            .weight(1f)
//                            .fillMaxHeight(.5f)
                            .background(Color.Blue)
                    ) {
                        Box(modifier = Modifier.weight(.5f)) {
                            ModifierExample()
                        }

                        Spacer(modifier = Modifier.width(5.dp))
                        Box(modifier = Modifier.weight(.5f)) {
                            ModifierExample()
                        }
                    }
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
//                            .fillMaxHeight(.5f)
                            .border(
                                color = Color.Red,
                                width = 5.dp,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .background(Color.Magenta),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
//                                .weight(1f)
                                .size(200.dp)
                                .clip(CircleShape)
                                .background(color = Color.Green)
                        ) {

                        }
                        Box(
                            modifier = Modifier
//                                .weight(1f)
                                .size(200.dp)
                                .clip(shape = RoundedCornerShape(30.dp))
                                .background(color = Color.Green)
                        ) {

                        }
                    }

                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            MyTextField()

                            var textState by remember {
//                        val textState by rememberSaveable {//this will save on screen configuration change.
                                //Remember this will work with mutableStateOf and not work with mutableStateListOf. We can do but more setup required.
                                mutableStateOf(value = "")
                            }


                            val nameListState = remember {
                                mutableStateListOf<String>()
                            }

                            MyTextFieldStateless(
                                textValue = textState,
                                onValueChange = { text ->
                                    textState = text
                                },
                                onAddClick = {
                                    nameListState.add(it)
                                }
                            )



                            LazyRow {
                                items(nameListState.size) { index ->
                                    BasicText(text = nameListState[index])
                                }
                            }

                            BasicText("State manage with viewmodel")

                            MyTextFieldStateless(
                                textValue = state.value.testState,
                                onValueChange = { text ->
                                    viewModel.updateText(text)
                                },
                                onAddClick = {
                                    viewModel.updateNamesList2()
                                    viewModel.updateText(it)
                                }
                            )

                            LazyRow {
                                items(viewModel.state.value.nameList.size) { index ->
                                    BasicText(text = viewModel.state.value.nameList[index])
                                }
                            }
                        }

                    }
                }

                /*Greeting(name = "Android App Dev.")
                Button(
                    onClick = { },
                    content = {
                        Text(text = "Click Here")
                    }
                )*/
//                BoxComposeSample()

            }
        }
    }
}


@Composable
fun BoxComposeSample() {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Middle of the screen")
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = "Hello", modifier = Modifier.align(Alignment.TopCenter))
            Text(text = "World", modifier = Modifier.align(Alignment.TopEnd))
        }
    }
}


@Composable
fun Greeting(name: String) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Welcome $name",
            color = Color.Red,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            tint = Color.Black
        )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )

        BasicText("Basic Text")

        TextField(value = "", onValueChange = {}, label = {
            Text(text = "Label")
        })

        FloatingActionButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
        }
        FloatingActionButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
        }

//EXTENDED FAB WITHOUT ICON
        ExtendedFloatingActionButton(
            text = {
                Text(text = "EXTENDED FAB")
            },
            onClick = { },
            icon = { Icon(Icons.Filled.Add, "") }
        )

    }
    ExtendedFloatingActionButton(
        text = {
            Text(text = "EXTENDED FAB")
        },
        onClick = { },
        icon = { Icon(Icons.Filled.Add, "") }
    )
}


@Composable
fun ModifierExample() {
    Box(
        modifier = Modifier
            .background(
                color = Color.LightGray,
                shape = RectangleShape
            )
            .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(30.dp))
//        .align(Alignment.Center)
//        .size(100.dp)
//        .width(100.dp)
//        .height(200.dp)
            .fillMaxSize(1f)
//            .fillMaxWidth(.6f)
//            .fillMaxHeight(.7f)
            .background(
                color = Color.Yellow,
                shape = RectangleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(40.dp))
            .border(10.dp, color = Color.Gray, shape = RoundedCornerShape(40.dp))
            .border(20.dp, color = Color.Green, shape = RoundedCornerShape(40.dp))
            .background(Color.LightGray)
            .clickable { println("Button Clicked") }

        ) {
            Text(
                text = "Button",
                color = Color.Red,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
    }
}

@Composable
fun MyTextField() {
    val textState = remember {
        mutableStateOf(value = "")
    }
    TextField(
        value = textState.value, onValueChange = {
            textState.value = it
        }, modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun MyTextFieldStateless(
    textValue: String,
    onValueChange: (String) -> Unit,
    onAddClick: (String) -> Unit
) {
    TextField(
        value = textValue,
        onValueChange = {
//            onValueChange.invoke(it)
            onValueChange(it)
        },
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.clickable {
                    onAddClick.invoke(textValue)
                }
            )
        }
    )
}