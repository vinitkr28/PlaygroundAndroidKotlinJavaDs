package cheezyCode.jetpackCompose.workbenchThree

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "WorkbeanchActivityThree"

class WorkbeanchActivityThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            TextInputComposeWithState()
//            Recomposable()

//            NotificationScreen()

            stateHosting()
        }
    }
}


