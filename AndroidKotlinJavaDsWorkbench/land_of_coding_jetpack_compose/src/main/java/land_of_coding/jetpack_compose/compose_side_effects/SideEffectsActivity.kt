package land_of_coding.jetpack_compose.compose_side_effects

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import land_of_coding.jetpack_compose.compose_side_effects.disposable_effect.LifecycleListenerExample
import land_of_coding.jetpack_compose.compose_side_effects.produce_state.PostCard
import land_of_coding.jetpack_compose.compose_side_effects.remember_updated_state.TimeoutWith2Buttons
import land_of_coding.jetpack_compose.compose_side_effects.side_effects.SystemBarsColorChanger
import land_of_coding.jetpack_compose.compose_side_effects.snapshot_flow.LoggingTestInput

class SideEffectsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //***** 1. Launched Effect *****

//            SideEffectsLaunchEffectExample()


            /*CounterExample(max = 10) { t ->
                Log.d("SideEffectsActivity", "onCreate: $t")
            }*/

            //***** 2. Remember Coroutine Scope *****

//            NameList()


            //***** 3. Disposable Effect *****

            /*var screen by remember {
                mutableStateOf("login")
            }

            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    screen = "home"
                }) {
                    Text(text = "Go to Home")
                }
            }

            when(screen) {
                "login" -> LoginScreen()
                "home" -> HomeScreen()
            }*/


            //***** 4. derivedStateOf *****

//            NumberListExample()

            //***** 5. produce state *****

//            PostCard(postId = 3)


            //***** 6. Side Effect *****
//            SystemBarsColorChanger(statusBarColor = Color.Red, navigationBarColors = Color.Green)

            //***** 7. remember updated state *****
//            TimeoutWith2Buttons()

            //***** 8. snapshot flow *****

            LoggingTestInput()
        }
    }
}


@Composable
fun LoginScreen() {
    LifecycleListenerExample(
        onResume = {
            Log.d("test", "On resume")
        }
    )
}


@Composable
fun HomeScreen() {

}

