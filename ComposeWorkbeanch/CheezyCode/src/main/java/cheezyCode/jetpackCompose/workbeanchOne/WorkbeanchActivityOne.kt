package cheezyCode.jetpackCompose.workbeanchOne

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class WorkbeanchActivityOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { RenderRenderBlogCategory() }
    }
}