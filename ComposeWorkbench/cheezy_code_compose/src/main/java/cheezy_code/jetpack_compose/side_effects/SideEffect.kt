package cheezy_code.jetpack_compose.side_effects

import android.media.MediaPlayer
import android.util.Log
import android.view.ViewTreeObserver
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cheezy_code.jetpack_compose.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TAG = "SideEffect"

class SideEffect {
}


// ***********************
var counter = 1

@Composable
fun HasSideEffect() {
    counter++
    Text(text = "CheezyCode")
}
// ***********************

//Side Effect
@Composable
fun ListComposable() {
    val categoryState = remember {
        mutableStateOf(emptyList<String>())
    }

    // 1. Suppose this is network call.
    // When the compose will recompose this function then it will call the API again
    // 2. Suppose fetchCategories will take some time then in this case UI will lag or it will fridge.
    categoryState.value = fetchCategories()

    LazyColumn {
        items(categoryState.value) {
            Text(text = it)
        }
    }
}

// ***********************

//Side Effect -> LaunchedEffect
@Composable
fun ListComposable2() {
    val categoryState = remember {
        mutableStateOf(emptyList<String>())
    }

    //no. of execution of LaunchedEffect depends on the key1.
    // When the key1 value will then then it will execute.
    LaunchedEffect(key1 = Unit) {
        categoryState.value = fetchCategories()
    }

    LazyColumn {
        items(categoryState.value) { item ->
            Text(text = item)
        }
    }
}

// ***********************
@Composable
fun Counter() {
    val count = remember {
        mutableIntStateOf(0)
    }
    Log.d(TAG, "Counter: ${count.intValue}")

    Button(onClick = { count.intValue++ }) {
        Text(text = "Increment Count")
    }

}

// ***********************
@Composable
fun Counter2() {
    val count = remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(key1 = false) {
        Log.d(TAG, "Counter: ${count.intValue}")
    }

    Button(onClick = { count.intValue++ }) {
        Text(text = "Increment Count")
    }

}

// ***********************
@Composable
fun Counter3() {
    val count = remember {
        mutableIntStateOf(0)
    }
    val key = count.intValue % 3 == 0

    LaunchedEffect(key1 = key) {
        Log.d(TAG, "Counter: ${count.intValue}")
    }

    Button(onClick = { count.intValue++ }) {
        Text(text = "Increment Count")
    }

}
// ***********************

@Composable
fun LaunchEffectComposable() {
    val counter = remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(key1 = Unit) {
        Log.d(TAG, "LaunchEffectComposable: Started...")
        try {
            for (i in 1..10){
                counter.intValue++
                delay(1000)
            }
        } catch (e: Exception){
            Log.d(TAG, "LaunchEffectComposable:Exception:: ${e.message}")
        }
    }

    val text = "Counter is running ${counter.intValue}"
    Column {
        Text(text = text)

        Button(onClick = {
//            @Composable invocations can only happen from the context of a @Composable function
//            LaunchedEffect(key1 = Unit) {  }
        }) {
            Text(text = "Click")
        }
    }
}
// ***********************
//remember coroutine scope
@Composable
fun LaunchEffectComposableWithRemember() {
    val counter = remember {
        mutableIntStateOf(0)
    }
    val scope = rememberCoroutineScope()

    var text = "Counter is running ${counter.intValue}"
    if (counter.intValue == 10){
        text = "Counter Stopped"
    }
    Column {
        Text(text = text)

        Button(onClick = {
            scope.launch {
                Log.d(TAG, "CoroutineScopeComposable: Started...")
                try {
                    for (i in 1..10){
                        counter.intValue++
                        delay(1000)
                    }
                } catch (e: Exception){
                    Log.d(TAG, "CoroutineScopeComposable:Exception:: ${e.message}")
                }
            }
        }) {
            Text(text = "Start")
        }
    }
}
// ***********************
//RememberUpdatedState

@Composable
fun RememberUnderstateCompose() {
    val counter = remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(key1 = Unit ){
        delay(2000)
        counter.intValue = 10
    }

//    CounterForRememberUnderstateCompose(counter.intValue)
    CounterForRememberUnderstateCompose2(counter.intValue)
}

@Composable
fun CounterForRememberUnderstateCompose(intValue: Int) {
    Text(text = intValue.toString())
}
// ------------------
@Composable
fun CounterForRememberUnderstateCompose2(intValue: Int) {
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.d(TAG, "CounterForRememberUnderstateCompose2: $intValue")
    }
    Text(text = intValue.toString())
}
// ------------------
@Composable
fun CounterForRememberUnderstateCompose3(intValue: Int) {
    LaunchedEffect(key1 = intValue) {
        delay(5000)
        Log.d(TAG, "CounterForRememberUnderstateCompose2: $intValue")
    }
    Text(text = intValue.toString())
}

// ------------------
@Composable
fun CounterForRememberUnderstateCompose4(intValue: Int) {
    val state = rememberUpdatedState(newValue = intValue)
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.d(TAG, "CounterForRememberUnderstateCompose2: ${state.value}")
    }
    Text(text = intValue.toString())
}
// ***********************
//7484491<-
//https://developer.android.com/jetpack/compose/side-effects

fun a() {
    Log.d(TAG, "a: I am A from App")
}

fun b() {
    Log.d(TAG, "b: I am B from App")
}

@Composable
fun AppForRememberUpdatedState() {
    val state = remember {
        mutableStateOf(::a)
    }
    Button(onClick = {
        state.value = ::b
    }) {
        Text(text = "Click to change state")
    }
    LandingScreen(state.value)
}

private const val SplashWaitTimeMillis = 5000L
@Composable
fun LandingScreen(onTimeout: () -> Unit) {

    // This will always refer to the latest onTimeout function that
    // LandingScreen was recomposed with
    val currentOnTimeout by rememberUpdatedState(onTimeout)

    // Create an effect that matches the lifecycle of LandingScreen.
    // If LandingScreen recomposes, the delay shouldn't start again.
    LaunchedEffect(true) {
        delay(SplashWaitTimeMillis)
        currentOnTimeout()
    }

    /* Landing screen content */
}
// ***********************
//Disposable Effect Handler

@Composable
fun DisposableEffectCompose() {
    val state = remember{
        mutableStateOf(false)
    }

    DisposableEffect(key1 = state.value) {
        Log.d(TAG, "DisposableEffectCompose: Disposable Effect started.")
        onDispose {
            Log.d(TAG, "DisposableEffectCompose: cleaning up side effects.")
        }
    }

    Button(onClick = {
        state.value = !state.value
    }) {
        Text(text = "Change State")
    }
}
// ***********************

@Composable
fun MediaComposable() {
    val context = LocalContext.current

    DisposableEffect(key1 = Unit) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.file_example_mp3_700kb)
        mediaPlayer.start()
        onDispose {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }
}

@Composable
fun DisposableEffectExampleMediaPlayer() {
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
//            MediaComposable()
        }
    }) {
        Text(text = "Play Media")
    }
}


@Composable
fun DisposableEffectExampleMediaPlayer2() {
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {

        }
    }) {
        Text(text = "Play Media")
    }
}

@Composable
fun KeyboardComposable() {
    val view = LocalView.current

    DisposableEffect(key1 = Unit) {

        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardVisible = insets?.isVisible(WindowInsetsCompat.Type.ime())
            Log.d(TAG, "KeyboardComposable: $isKeyboardVisible")
        }
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener { listener }
        }
    }
}

@Composable
fun KeyboardPopupTest() {
    KeyboardComposable()
    TextField(value = "", onValueChange = {

    })
}


// ***********************

//ProduceState
@Composable
fun LoaderCompose() {

    val degree = produceState(initialValue = 0) {
        while (true) {
            delay(16)
            value = (value + 10) % 360
        }
    }


    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)) {
        Column {
            Image(
                imageVector = Icons.Default.Refresh,
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .rotate(degree.value.toFloat())
            )
            Text(
                text = "Loading",
                modifier = Modifier
                    .fillMaxWidth(Float.MAX_VALUE)
                    .align(Alignment.CenterHorizontally)
            )
        }

    }
}

@Preview(device = Devices.DEFAULT, showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoaderCompose() {
    LoaderCompose()
}


// ***********************
//Derived State
@Composable
fun DerivedCompose() {
    val tableOf = remember {
        mutableIntStateOf(5)
    }
    val index = remember {
        mutableIntStateOf(1)
    }

    val message by remember {
        derivedStateOf {
            "${tableOf.intValue} * ${index.intValue} = ${tableOf.intValue * index.intValue}"
        }
    }

    Box {
        Text(text = message, style = MaterialTheme.typography.headlineMedium)
    }
}

// ------------------
@Composable
fun DerivedCompose1() {
    val tableOf = remember {
        mutableIntStateOf(5)
    }
    val index = produceState(initialValue = 1) {
        repeat(9){
            delay(1000)
            value++
        }
    }

    val message by remember {
        derivedStateOf {
            "${tableOf.intValue} * ${index.value} = ${tableOf.intValue * index.value}"
        }
    }

    Box {
        Text(text = message, style = MaterialTheme.typography.headlineMedium)
    }
}

// ***********************


// ***********************


// ***********************

fun fetchCategories(): List<String> {
    return listOf("One", "Two", "Three", "Four")
}

@Composable
fun ShowInSideEffectActivity() {
//    ListComposable()
//    Counter()
//    Counter2()
//    Counter3()
//    LaunchEffectComposable()
//    LaunchEffectComposableWithRemember()
//    RememberUnderstateCompose()
    AppForRememberUpdatedState()
}