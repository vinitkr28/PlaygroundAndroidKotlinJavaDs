package cheezy_code.jetpack_compose.workbenchOne

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class WorkbenchActivityOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { RenderRenderBlogCategory() }
    }
}