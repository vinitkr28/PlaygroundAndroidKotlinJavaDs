@file:OptIn(ExperimentalMaterial3Api::class)

package com.philipp_lackner.swap_to_dismiss

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.philipp_lackner.swap_to_dismiss.ui.theme.SwipeToDeleteComposeTheme
import kotlinx.coroutines.delay

class SwapToDismissActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SwipeToDeleteComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val programmingLanguages = remember {
                        mutableStateListOf(
                            "Kotlin",
                            "Java",
//                            "C++",
//                            "Swift",
//                            "Python",
//                            "Ruby",
//                            "Curl",
//                            "Objective C",
//                            "Javascript",
//                            "Groovy",
//                            "PHP",
//                            "Go",
                        )
                    }

                    Column {
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 0.dp, vertical = 18.dp)
                                .background(Color.Cyan),
                            text = "Swipe to Delete Program..${programmingLanguages.size}"
                        )

                        Spacer(modifier = Modifier.padding(3.dp))

                        if (programmingLanguages.size == 0) {
                            Box(
                                modifier = Modifier.fillMaxSize().align(Alignment.CenterHorizontally)
                            ) {
                                Text(text = "No Programming language found.")
                            }
                            return@Column
                        } else {

                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {

                                /*items(programmingLanguages.size) { index ->
                                    Text(
                                        modifier = Modifier
                                            .border(width = 2.dp, color = Color.Green)
                                            .background(Color.LightGray)
                                            .fillMaxWidth()
                                            .padding(horizontal = 12.dp, vertical = 16.dp),
                                        text = programmingLanguages[index],
                                        style = TextStyle(fontWeight = FontWeight.ExtraBold)
                                    )
                                }*/


                                items(
                                    items = programmingLanguages,
                                    key = { it }
                                ) { language ->
                                    SwipeToDeleteContainer(
                                        item = language,
                                        onDelete = {
                                            programmingLanguages -= language
                                        }
                                    ) { eachLanguage ->
                                        Text(
                                            text = eachLanguage,
                                            modifier = Modifier
                                                .border(width = 2.dp, color = Color.Green)
                                                .background(Color.LightGray)
                                                .fillMaxWidth()
                                                .padding(horizontal = 12.dp, vertical = 16.dp),
//                                            .fillMaxWidth()
//                                            .background(MaterialTheme.colorScheme.background)
//                                            .padding(16.dp)
                                        )

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun <T> SwipeToDeleteContainer(
    item: T,
    onDelete: (T) -> Unit,
    animationDuration: Int = 500,
    content: @Composable (T) -> Unit
) {
    var isRemoved by remember {
        mutableStateOf(false)
    }
    val state = rememberDismissState(
        confirmValueChange = { value ->
            if (value == DismissValue.DismissedToStart) {
                isRemoved = true
                true
            } else {
                false
            }
        }
    )

    LaunchedEffect(key1 = isRemoved) {
        if (isRemoved) {
            delay(animationDuration.toLong())
            onDelete(item)
        }
    }

    AnimatedVisibility(
        visible = !isRemoved,
        exit = shrinkVertically(
            animationSpec = tween(durationMillis = animationDuration),
            shrinkTowards = Alignment.Top
        ) + fadeOut()
    ) {

        SwipeToDismiss(
            state = state,
            background = {
                DeleteBackground(swipeDismissState = state)
            },
            dismissContent = { content(item) },
            directions = setOf(DismissDirection.EndToStart)
        )
    }

}

@Composable
fun DeleteBackground(
    swipeDismissState: DismissState
) {

    val color = if (swipeDismissState.dismissDirection == DismissDirection.EndToStart) {
        Color.Red
    } else Color.Transparent

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = null,
            tint = Color.White
        )
    }

}