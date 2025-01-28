package land_of_coding.jetpack_compose.compose_examples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import land_of_coding.jetpack_compose.R
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme

class PostCardActivity : ComponentActivity() {


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
                    val text =
                        "With China's economy in a lasting slump, investors and entrepreneurs are seeking the next China. They feel unwelcome by their government, which in recent years has sent an ominous message by clamping down on private companies. The heightened tensions between"
                    val publisher =
                        Publisher("NYT News Service", R.drawable.dp_pic, "Backend Developer")
                    MyCustomCard(
                        modifier = Modifier.fillMaxWidth(fraction = 0.8f),
                        image = R.drawable.elephant,
                        title = "Chinese tech investors struggle for a toehold in Silicon Valley",
                        text = text,
                        publisher = publisher
                    )
                }
            }
        }
    }
}