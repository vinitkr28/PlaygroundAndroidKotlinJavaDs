package land_of_coding.jetpack_compose.compose_examples

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import land_of_coding.jetpack_compose.ui.theme.LandOfCodingJetpackComposeTheme

class TextFieldExampleActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LandOfCodingJetpackComposeTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
//                        .background(Color.Black.copy(alpha = 0.9f)),
                    contentAlignment = Alignment.Center
                ) {
                    TextFieldExample()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldExample(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember {
            mutableStateOf("")
        }

        var isPasswordVisible by remember {
            mutableStateOf(false)
        }

        val forecastRequester = remember {
            FocusRequester()
        }

        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.AcUnit, contentDescription = null)
            },
            trailingIcon = {
                TextButton(onClick = {
                    isPasswordVisible = !isPasswordVisible
                }) {
                    Text(text = if (isPasswordVisible) "Hide" else "Show")
                }
            },
//            colors = TextFieldDefaults.textFieldColors(
//                containerColor = Color.Transparent,
//                cursorColor = Color.Red
//            ),
            singleLine = true,
            placeholder = {
                Text(text = "Password")
            },
//            label = {
//                Text(text = "Enter Password")
//            }
//            visualTransformation = PasswordVisualTransformation('\u2022'),//unicode character
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(
                '\u00AE'
            ),
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Go
            ),
            keyboardActions = KeyboardActions(
                onGo = {
                    Log.d("TextFieldExampleActivity", "TextFieldExample: ")
                }
            ),
            modifier = Modifier.focusRequester(forecastRequester)

        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            forecastRequester.requestFocus()
        }) {
            Text(text = "Request focus")
        }

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(value = text, onValueChange = {
            text = it
        })

        Spacer(modifier = Modifier.height(30.dp))

        BasicTextField(value = text, onValueChange = {
            text = it
        })
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
private fun TextFieldExamplePreview() {
    LandOfCodingJetpackComposeTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
//                .background(colorResource(id = R.color.black).copy(alpha = 0.9f)),
            contentAlignment = Alignment.Center,
        ) {
            TextFieldExample()
        }
    }
}