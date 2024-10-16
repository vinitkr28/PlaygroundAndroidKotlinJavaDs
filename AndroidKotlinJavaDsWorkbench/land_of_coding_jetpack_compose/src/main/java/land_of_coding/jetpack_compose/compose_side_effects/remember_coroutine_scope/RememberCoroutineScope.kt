package land_of_coding.jetpack_compose.compose_side_effects.remember_coroutine_scope

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardDoubleArrowDown
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun NameList(modifier: Modifier = Modifier) {
    val names = remember {
        (0..100).map { "Name #$it" }
    }

    val scrollState = rememberScrollState()


    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    scrollState.animateScrollTo(scrollState.maxValue)
                }
            }) {
                Icon(imageVector = Icons.Default.KeyboardDoubleArrowDown, contentDescription = "")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(scrollState)
        ) {
            names.forEach { name ->
                Text(
                    text = name, modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}