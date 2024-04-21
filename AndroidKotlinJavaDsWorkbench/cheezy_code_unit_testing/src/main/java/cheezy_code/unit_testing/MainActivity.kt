package cheezy_code.unit_testing

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val qm = QuoteManager()
        qm.populateQuoteFromAssets(this, "quote.json")
        val quotes = qm.quoteList
        Log.d(TAG, "onCreate: ${quotes.joinToString(", ")}")
        Log.d(TAG, "onCreate: ${listOf(quotes)}")//onCreate: [[Lcheezy_code.unit_testing.Quote;@3f74642]
//        Log.d(TAG, "onCreate: ${Arrays.toString(quotes)}")
        Log.d(TAG, "onCreate: ${quotes.contentToString()}")
    }
}