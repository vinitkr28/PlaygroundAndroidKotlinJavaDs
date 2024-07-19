package land_of_coding.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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


                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                ) {
                    Box(modifier = Modifier.weight(.5f)) {
                        ModifierExample()
                    }

                    Spacer(modifier = Modifier.width(5.dp))
                    Box(modifier = Modifier.weight(.5f)) {
                        ModifierExample()
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
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello", modifier = Modifier.align(Alignment.TopCenter))
        Text(text = "World", modifier = Modifier.align(Alignment.TopEnd))
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Welcome $name", color = Color.Red, fontSize = 22.sp, fontWeight = FontWeight.Bold)

    Icon(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        tint = Color.Black
    )

    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null
    )

    TextField(value = "", onValueChange = {}, label = {
        Text(text = "Label")
    })

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