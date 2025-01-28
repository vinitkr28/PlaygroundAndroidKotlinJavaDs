package land_of_coding.jetpack_compose.compose_side_effects.derived_state_of

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun NumberListExample() {
    val numbers = remember {
        (0..100).toList()
    }

    val scrollState = rememberLazyListState()

    val isFABVisable by remember {
        derivedStateOf {
            scrollState.firstVisibleItemIndex >= 5
        }
    }

    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            if(isFABVisable) {
                FloatingActionButton(onClick = {
                    scope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "")
                }
            }
        }
    ) { paddingValue ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue), state = scrollState
        ) {
            items(numbers.size) { n ->
                Text(
                    text = n.toString(), modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}