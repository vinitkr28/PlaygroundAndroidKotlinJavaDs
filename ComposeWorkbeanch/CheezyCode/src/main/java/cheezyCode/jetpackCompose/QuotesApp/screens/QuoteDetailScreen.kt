package cheezyCode.jetpackCompose.QuotesApp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cheezyCode.jetpackCompose.QuotesApp.DataManager
import cheezyCode.jetpackCompose.QuotesApp.models.Quote
import cheezyCode.jetpackCompose.R

@Preview(showBackground = true, device = Devices.PIXEL_2_XL)
@Composable
fun PreviewQuoteDetail() {
    QuoteDetail(
        Quote(
            "",
            "Chetan Bhagat",
            "",
            "",
            3,
            "Five Point Someone"
        )
    )
}

@Composable
fun QuoteDetail(quote: Quote) {

    BackHandler {
        DataManager.switchPages(null)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
//                Brush.radialGradient(
                Brush.sweepGradient(
                    colors = listOf(Color(0xFFffffff), Color(0xFFE3E3E3))
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(1f)
                .background(Color.Blue),
        ) {
            Image(
                imageVector = Icons.Filled.Close,
                contentDescription = "",
                alignment = Alignment.TopEnd,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
                        DataManager.switchPages(null)
                    }
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.background(Color.Magenta)
                    //                    .align(Alignment.CenterHorizontally)
//                    .padding(10.dp, 16.dp)
                    .border(2.dp, Color.Green, RoundedCornerShape(6.dp))
                    .padding(10.dp, 16.dp)
                    .fillMaxWidth(1f)
                    .background(Color.Yellow)
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180F)
                )
                Text(
                    text = "\uD83D\uDCD8${quote.book_name}",
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "\uD83D\uDE4E${quote.author}",
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }

}