package cheezy_code.jetpack_compose.workbenchThree

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "WorkbenchActivityThree"

class WorkbenchActivityThree : AppCompatActivity() {
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


