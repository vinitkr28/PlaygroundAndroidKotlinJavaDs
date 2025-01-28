package land_of_coding.jetpack_compose.compose_side_effects.produce_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.seconds

@Composable
fun PostCard(postId: Int) {

    // produceState example
    val post by produceState<Result<Post>?>(initialValue = null) {
        value = getPostInformation(postId)
    }


    // **** same as produceState example
    var post1 by remember {
        mutableStateOf<Result<Post>?>(null)
    }
    LaunchedEffect(key1 = Unit) {
        post1 = getPostInformation(postId)
    }
    // same as produceState example ****



    if (post == null) {
        //Loading
    } else {
        post?.onSuccess {

        }?.onFailure {

        }
    }
}

suspend fun getPostInformation(id: Int): Result<Post> {
    return withContext(Dispatchers.IO) {
        delay(3.seconds)

        Result.success(
            Post(
                id = id,
                name = "",
                imageUrl = ""
            )
        )
    }
}