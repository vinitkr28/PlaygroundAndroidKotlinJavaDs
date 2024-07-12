package land_of_coding.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LandOfCodingJetpackComposeTheme {
                Greeting(name = "Android App Dev.")
                Button(
                    onClick = { },
                    content = {
                        Text(text = "Click Here")
                    }
                )

            }
        }
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

    FloatingActionButton(onClick = {  }) {
        Icon(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null)
    }

//EXTENDED FAB WITHOUT ICON
    ExtendedFloatingActionButton(
        text = {
            Text(text = "EXTENDED FAB")
        },
        onClick = {  },
        icon ={ Icon(Icons.Filled.Add,"")}
    )




}