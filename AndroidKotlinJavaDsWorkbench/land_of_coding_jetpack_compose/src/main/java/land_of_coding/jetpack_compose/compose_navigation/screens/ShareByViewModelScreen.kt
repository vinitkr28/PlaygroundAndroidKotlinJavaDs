package land_of_coding.jetpack_compose.compose_navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import land_of_coding.jetpack_compose.compose_navigation.Person


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShareByViewModelScreen(
    navigateToShareToViewModelScreen: (Person) -> Unit,
    navigateBackToA: () -> Unit
) {

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "ShareByViewModelScreen") }) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var personName by remember {
                mutableStateOf("")
            }

            var personAge by remember {
                mutableIntStateOf(-1)
            }

            var personCity by remember {
                mutableStateOf("")
            }

            TextField(value = personName, onValueChange = { personName = it })

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = personAge.toString(),
                onValueChange = { age ->
                    personAge = age.toInt()
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = personCity, onValueChange = { personCity = it })

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                navigateToShareToViewModelScreen.invoke(
                    Person(
                        77,
                        personName,
                        personAge,
                        personCity
                    )
                )
            }) {
                Text(text = "Go to ShareToViewModelScreen")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                navigateBackToA.invoke()
            }) {
                Text(text = "Back to A")
            }
        }
    }
}
