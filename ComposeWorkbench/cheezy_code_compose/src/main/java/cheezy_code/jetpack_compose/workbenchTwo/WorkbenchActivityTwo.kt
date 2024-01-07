package cheezy_code.jetpack_compose.workbenchTwo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import cheezy_code.jetpack_compose.R

class WorkbenchActivityTwo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workbench_two)

        val composeView = findViewById<ComposeView>(R.id.composeViewOne)

        composeView.setContent {
//            SampleTextFieldTwo()
//            LayoutRowOne(value1 = "ONE", value2 = "TWO")
            CircularImage()
        }


    }
}