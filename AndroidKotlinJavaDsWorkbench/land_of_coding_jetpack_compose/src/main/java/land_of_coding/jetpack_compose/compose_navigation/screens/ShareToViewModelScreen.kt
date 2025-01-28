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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import land_of_coding.jetpack_compose.compose_navigation.Person


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShareToViewModelScreen(
    person: Person,
    navigateBackToShareByViewModelScreen: () -> Unit,
    navigateBackToA: () -> Unit
) {

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "ShareToViewModelScreen") }) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Person:: $person")

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                navigateBackToShareByViewModelScreen.invoke()
            }) {
                Text(text = "Back To ShareByViewModelScreen")
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
