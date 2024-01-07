package cheezy_code.jetpack_compose.colors_typography_in_theme

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import cheezy_code.jetpack_compose.ui.theme.ComposePlaygroundTheme

private const val TAG = "ColorsTypographyInThemA"
class ColorsTypographyInThemActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            TextWithCustomStyle()
//            TextWithThemeColor()
            TextWithThemeColorInComposePlaygroundTheme()
        }
    }
}

@Composable
fun TextWithCustomStyle() {
    ComposePlaygroundTheme {
        Surface {
            Text(text = "Some Text", style = MaterialTheme.typography.headlineLarge)
        }
    }
}

@Composable
fun TextWithThemeColor(ctx: Context, changeTheme: () -> Unit) {
    Column(Modifier.background(MaterialTheme.colorScheme.background)) {
        Text(text = "Some Text", style = MaterialTheme.typography.headlineLarge)
        Button(onClick = {
            Toast.makeText(ctx, "Toast message", Toast.LENGTH_SHORT).show()

            changeTheme()
        }) {
            Text(text = "Change Theme")
        }
    }
}

@Composable
fun TextWithThemeColorInComposePlaygroundTheme() {
    Log.d(TAG, "LocalConfiguration.current.uiMode:: ${LocalConfiguration.current.uiMode}")
    val ctx = LocalContext.current.applicationContext
    val theme = remember {
        mutableStateOf(false)
    }
    ComposePlaygroundTheme(dynamicColor = theme.value) {
//        TextWithThemeColor { theme.value = !theme.value }
        Surface {
            TextWithThemeColor(ctx) { theme.value = !theme.value }
        }
    }
}