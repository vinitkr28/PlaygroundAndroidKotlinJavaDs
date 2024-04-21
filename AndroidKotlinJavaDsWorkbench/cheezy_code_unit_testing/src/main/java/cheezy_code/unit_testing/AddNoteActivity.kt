package cheezy_code.unit_testing

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddNoteActivity : AppCompatActivity() {

    lateinit var editTextAddNote: TextView
    lateinit var editTextDescriptionWrite: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_note)
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */

        editTextAddNote = findViewById(R.id.editTextAddNote)
        editTextDescriptionWrite = findViewById(R.id.editTextDescriptionWrite)
    }

    fun onSubmitClicked(view: View) {
        val note_title = editTextAddNote.text.toString()
        val note_description = editTextDescriptionWrite.text.toString()

        val intent = Intent(this, DisplayNoteActivity::class.java)

        val b = Bundle()
        b.putString("note_title", note_title)
        b.putString("note_description", note_description)
        intent.putExtras(b)
        startActivity(intent)
    }
}