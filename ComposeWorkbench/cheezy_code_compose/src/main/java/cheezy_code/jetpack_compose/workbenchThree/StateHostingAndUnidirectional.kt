package cheezy_code.jetpack_compose.workbenchThree

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val TAG = "StateHostingAndUnidirec"

class StateHostingAndUnidirectional {
}


@Composable
fun NotificationScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        NotificationCounter()
        MessageBar()
    }
}

//NotificationCounter is stateful composable
@Composable
fun NotificationCounter() {
    Log.d(TAG, "NotificationCounter called.")
    val count: MutableState<Int> = rememberSaveable {
        mutableIntStateOf(0)
    }

    Column {
        Text(text = "You have sent $count notifications")

        Button(onClick = {
            count.value++
            Log.d(TAG, "Button Clicked")
        }) {
            Text(text = "Send Notification")
        }
    }
}

//MessageBar is stateless composable
@Composable
fun MessageBar() {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Row(
            Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Outlined.Face,
                contentDescription = "",
                Modifier.padding(4.dp)
            )
            Text(text = "Message sent so far - 10")
        }
    }
}

//********************
//State Hosting Concept
//Unidirectional flow
//NotificationScreenWithState - top level compose
//Data is going to the bottom
//Event is going in upper direction
@Composable
fun NotificationScreenWithState() {
    val countStateOutside: MutableState<Int> = rememberSaveable {
        mutableIntStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        ////NotificationCounterStateOutside and MessageBarWithState - child level compose
        NotificationCounterStateOutside(countStateOutside.value) {countStateOutside.value++}
        MessageBarWithState(countStateOutside.value)
    }
}

@Composable
fun NotificationCounterStateOutside(value: Int, countStateOutside: () -> Unit) {
    Log.d(TAG, "NotificationCounter called.")


    Column {
        Text(text = "You have sent $value notifications")

        Button(onClick = {
            countStateOutside()
            Log.d(TAG, "Button Clicked")
        }) {
            Text(text = "Send Notification")
        }
    }
}

@Composable
fun MessageBarWithState(countStateOutside: Int) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Row(
            Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Outlined.Face,
                contentDescription = "",
                Modifier.padding(4.dp)
            )
            Text(text = "Message sent so far - $countStateOutside")
        }
    }
}

@Composable
fun stateHosting() {
    /*NotificationCounter()
    MessageBar()*/

NotificationScreenWithState()

}

@Preview(showSystemUi = true)
@Composable
fun PreviewMessageBar() {
    NotificationScreenWithState()
}