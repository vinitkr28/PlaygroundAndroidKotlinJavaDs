package cheezy_code.cheezy_code_compose_advance

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cheezy_code.cheezy_code_compose_advance.tweetsy.api.TweetsyAPI
import cheezy_code.cheezy_code_compose_advance.tweetsy.screens.CategoryScreen
import cheezy_code.cheezy_code_compose_advance.tweetsy.screens.DetailScreen
import cheezy_code.cheezy_code_compose_advance.ui.theme.ComposeWorkbeanchTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var tweetsyAPI: TweetsyAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        

        justForTest()
        
        setContent {
            ComposeWorkbeanchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CategoryScreen()
//                    DetailScreen()
                }
            }
        }
    }


    fun justForTest(){
        GlobalScope.launch {
            var response = tweetsyAPI.getCategory()
            Log.d(TAG, "onCreate: response.body():: ${response.body()}")

            var result = response.body()
            result!!.distinct()

            Log.d(TAG, "onCreate: result:: $result")
        }
    }
}