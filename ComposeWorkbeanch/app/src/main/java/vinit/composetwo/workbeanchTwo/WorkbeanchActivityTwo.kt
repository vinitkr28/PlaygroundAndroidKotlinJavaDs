package vinit.composetwo.workbeanchTwo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.ui.platform.ComposeView
import vinit.composetwo.R

class WorkbeanchActivityTwo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workbeanch_two)

        val composeView = findViewById<ComposeView>(R.id.composeViewOne)

        composeView.setContent {
//            SampleTextFieldTwo()
//            LayoutRowOne(value1 = "ONE", value2 = "TWO")
            CircularImage()
        }


    }
}