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
fun EnteredPersonDataScreen(
    person: Person,
    navigateBackToA: () -> Unit,
    navigateBackToPassObjectScreen: () -> Unit
) {

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Pass Object Screen") }) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = person.toString())

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                navigateBackToPassObjectScreen.invoke()
            }) {
                Text(text = "Back to Pass Object Screen")
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