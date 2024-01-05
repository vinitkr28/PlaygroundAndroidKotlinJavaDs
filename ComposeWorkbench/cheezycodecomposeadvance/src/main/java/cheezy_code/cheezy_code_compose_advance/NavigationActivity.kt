package cheezy_code.cheezy_code_compose_advance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    //There are multiple node inside the NavGraph and on the basis of this we define the destination
    NavHost(navController = navController, startDestination = "registration") {
        composable(route = "registration") {
            RegistrationScreen {
                navController.navigate("login/$it")
            }
        }
        composable(route = "login/{loginName}", arguments = listOf(
            navArgument("loginName") {
                type = NavType.StringType
            }
        )) {
            LoginScreen {
                navController.navigate("main/email/userName/male/21")
            }
        }
        composable(
            route = "main/{email}/{userName}/{gender}/{age}", arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                },
                navArgument("userName") {
                    type = NavType.StringType
                },
                navArgument("gender") {
                    type = NavType.StringType
                },
                navArgument("age") {
                    type = NavType.IntType
                },
            )
        ) {
            var email = "NA"
            var userName = "NA"
            var gender = "not defined"
            var age = -1
            it.arguments?.let { bundle ->
                email = bundle.getString("email").toString()
                userName = bundle.getString("userName").toString()
                gender = bundle.getString("gender").toString()
                age = bundle.getInt("age")
            }
            MainScreen(email, userName, gender, age) {
                navController.navigate("registration")
            }
        }
    }
}

@Composable
fun RegistrationScreen(onClick: (userName: String) -> Unit) {
    Text(
        text = "RegistrationScreen",
        textAlign = TextAlign.Center, // make text center horizontal
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .background(Color.Cyan)
            .wrapContentHeight(Alignment.Bottom)
            .clickable { onClick("Vinit1") } // align bottom
    )
}


@Composable
fun LoginScreen(name: String = "", onClick: (userName: String) -> Unit) {
    Text(text = "Login Screen $name",
        color = MaterialTheme.colorScheme.primary,
        fontSize = 32.sp,
        fontFamily = FontFamily.Cursive,
        textAlign = TextAlign.Center,
        modifier = Modifier.clickable {
            onClick("VinitK.")
//            Toast.makeText(context, "Hello Friends"Toast.LENGTH_LONG).show()
        })
}


@Composable
fun MainScreen(email: String, userName: String, gender: String, age: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .clickable(onClick = {
                onClick()
            }) /*question = "3 Bananas required"*/
            .clip(shape = RoundedCornerShape(16.dp)),
    ) {
        Box(
            modifier = Modifier
//            .preferredSize(350.dp)
                .border(width = 4.dp, color = Gray, shape = RoundedCornerShape(16.dp)),
//            alignment = Alignment.Center
        ) {
            Text(
                text = "MainScreen\t$email\t$userName\t$gender\t$age",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center,
                style = typography.headlineLarge,
            )
            //...
        }
    }
}