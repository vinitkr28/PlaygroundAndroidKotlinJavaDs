package com.philipp_lackner.lazyColumnLag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.philipp_lackner.R
import com.philipp_lackner.lazyColumnLag.ui.theme.AndroidKotlinJavaDsWorkbenchTheme

class LazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val compressedResourceIds = listOf(
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
        )

        val tags = listOf(
            "speaker",
            "android",
            "iOS",
            "devOps",
            "audience"
        )


        val images = (1..100).map {
            MyImage(
                resId = compressedResourceIds.random(),
                title = "Random title $it",
                tags = tags
                    .shuffled()
                    .take((1..5).random())
            )
        }


        setContent {
            AndroidKotlinJavaDsWorkbenchTheme {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(
                        items = images,
                        key = { eachImage ->
                            eachImage.id
                        }
                    ) { image ->
                        ImageDetails(image)

                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ImageDetails(image: MyImage, modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = image.resId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = image.title, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                image.tags.forEach { tag ->
                    SuggestionChip(onClick = { }, label = { Text(text = tag) })
                }
            }
        }
    }
}
