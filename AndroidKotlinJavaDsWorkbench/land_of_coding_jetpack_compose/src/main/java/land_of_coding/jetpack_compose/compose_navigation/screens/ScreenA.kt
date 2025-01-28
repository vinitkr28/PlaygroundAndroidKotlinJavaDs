package land_of_coding.jetpack_compose.compose_navigation.screens

import androidx.compose.foundation.background
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenA(
    navigateToB: (String) -> Unit,
    navigateToPassObjectScreen: () -> Unit,
    navigateToShareWithViewModel: () -> Unit
) {

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Screen A") }) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Green)
                .padding(top = it.calculateTopPadding()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var text by remember {
                mutableStateOf("")
            }


            TextField(value = text, onValueChange = {
                text = it
            })
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                navigateToB.invoke(text)
            }) {
                Text(text = "Go to B")
            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                navigateToPassObjectScreen.invoke()
            }) {
                Text(text = "Go to Pass Object Screen")
            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                navigateToShareWithViewModel.invoke()
            }) {
                Text(text = "Share With View Model")
            }
        }
    }
}