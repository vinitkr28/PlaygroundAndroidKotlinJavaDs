package cheezy_code.unit_testing

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textview.MaterialTextView

class DisplayNoteActivity : AppCompatActivity() {
    lateinit var textDisplayNote: MaterialTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_display_note)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        textDisplayNote = findViewById(R.id.textDisplayNote)


        val note_title = intent.getStringExtra("note_title")
        val note_description = intent.getStringExtra("note_description")


//        "Title: $note_title\nDescription: $note_description".also { textDisplayNote.text = it }
        "$note_title $note_description".also { textDisplayNote.text = it }
    }
}