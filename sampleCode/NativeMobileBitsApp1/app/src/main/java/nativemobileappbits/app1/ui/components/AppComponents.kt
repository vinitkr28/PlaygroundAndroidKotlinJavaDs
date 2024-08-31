package nativemobileappbits.app1.ui.components

import android.transition.CircularPropagation
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.loader.content.Loader

@Composable
fun Loader() {
    CircularProgressIndicator(
        modifier = Modifier
            .size(50.dp)
            .padding(10.dp),
        color = Color.Black
    )
}