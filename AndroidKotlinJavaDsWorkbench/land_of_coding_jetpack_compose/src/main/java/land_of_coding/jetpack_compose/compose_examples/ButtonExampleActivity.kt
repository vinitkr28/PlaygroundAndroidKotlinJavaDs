package land_of_coding.jetpack_compose.compose_examples

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme

class ButtonExampleActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LandOfCodingJetpackComposeTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.9f)),
                    contentAlignment = Alignment.Center
                ) {
                    ButtonExample()
                }
            }
        }
    }
}


@Composable
fun ButtonExample(modifier: Modifier = Modifier) {
    Column {

        //Compose Material Catalog

        IconButton(onClick = {  }) {
            Icon(imageVector = Icons.Default.Apps, contentDescription = null)
        }

        Spacer(modifier = Modifier.height(20.dp))

        TextButton(onClick = {  }) {
            Text(text = "Click Me")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier
                .height(50.dp)
                .widthIn(max = 150.dp),
            shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp),
            enabled = true,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp,
                pressedElevation = 40.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2D4356),
                contentColor = Color.Green,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.LightGray
            ),
            onClick = { }
        ) {
            Icon(imageVector = Icons.Default.AcUnit, contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Click Me")
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
private fun ButtonExamplePreview() {
    LandOfCodingJetpackComposeTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
//                .background(colorResource(id = R.color.black).copy(alpha = 0.9f)),
            contentAlignment = Alignment.Center,
        ) {
            ButtonExample()
        }
    }
}