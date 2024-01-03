package cheezy_code.jetpack_compose.side_effects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class SideEffectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { ShowInSideEffectActivity() }
    }
}