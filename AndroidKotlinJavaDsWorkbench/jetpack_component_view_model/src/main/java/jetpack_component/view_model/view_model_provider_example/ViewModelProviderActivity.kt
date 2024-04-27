package jetpack_component.view_model.view_model_provider_example

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import jetpack_component.view_model.R

private const val TAG = "ViewModelProviderActivi"
class ViewModelProviderActivity : AppCompatActivity() {
    lateinit var myViewModel: MyViewModel

    private var currentTimeGlobal = System.currentTimeMillis()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_model_provider)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewModelStoreOwner: ViewModelStoreOwner = this
        myViewModel = ViewModelProvider(viewModelStoreOwner).get(MyViewModel::class.java)


        Log.d(TAG, "onCreate:viewModelStore: ${viewModelStoreOwner.hashCode()}")
        Log.d(TAG, "onCreate:viewModelStoreOwner.viewModelStore: ${viewModelStoreOwner.viewModelStore.hashCode()}")
        Log.d(TAG, "onCreate:currentTimeGlobal: ${currentTimeGlobal}")



    }
}