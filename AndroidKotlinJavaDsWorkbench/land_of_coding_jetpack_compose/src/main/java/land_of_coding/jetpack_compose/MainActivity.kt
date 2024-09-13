package land_of_coding.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            LandOfCodingJetpackComposeTheme {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                    Row(
                        modifier = Modifier
                            .weight(.5f)
//                            .fillMaxHeight(.5f)
                            .background(Color.Blue)
                    ) {
                        Box(modifier = Modifier.weight(.5f)) {
                            ModifierExample()
                        }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        MyTextField()

//                        val textState by remember {
                        val textState by rememberSaveable {
                            mutableStateOf(value = "")
                        }
                        MyTextFieldStateless(textValue = textState, onValueChange = {

                        Spacer(modifier = Modifier.width(5.dp))
                        Box(modifier = Modifier.weight(.5f)) {
                            ModifierExample()
                        }
                    }
                    Row(
                        modifier = Modifier
                            .weight(.5f)
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
                }
                        }, onAddClick = {

                        }
                        )
                    }

                }
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
fun MyTextFieldStateless(
    textValue: String,
    onValueChange: (String) -> Unit,
    onAddClick: () -> Unit
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
                imageVector = Icons.Default.AcUnit,
                contentDescription = null,
                modifier = Modifier.clickable {
                    onAddClick.invoke()
                }
            )
        }
    )
}
