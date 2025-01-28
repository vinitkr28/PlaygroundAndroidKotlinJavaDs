package com.androidtopics

import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.provider.DocumentsContract
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidtopics.ui.theme.AndroidKotlinJavaDsWorkbenchTheme
import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.InputStreamReader

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {

    var fileContent = ""

    private val createFile =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            it.data?.data?.let {
                createFile(it, fileContent)
            }
        }

    private val readFile = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        it.data?.data?.let {
            val content = readFile(it)
            Log.d(TAG, "Content: \t$content")
        }
    }

    private val deleteFile = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        it.data?.data?.let {
            deleteFile(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidKotlinJavaDsWorkbenchTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }


    private fun createFile(fileName: String) {
        val bundle = Bundle()
        bundle.putString(Intent.EXTRA_TITLE, fileName)

        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "text/plain"
        intent.putExtras(bundle)

        createFile.launch(intent)
    }

    private fun readFile() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "test/*"

        readFile.launch(intent)
    }

    private fun readFile(uri: Uri): String {
        try {
            val fileInputStream = this.contentResolver.openInputStream(uri)
            val bufferReader = BufferedReader(InputStreamReader(fileInputStream))

            val line = StringBuilder()

            do {
                val l = bufferReader.readLine()
                l?.let {
                    line.append(it)
                }
            } while (l != null)

            return line.toString()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }

    fun createFile(uri: Uri, fileContent: String) {
        try {
            val parcelFileDescriptor: ParcelFileDescriptor? =
                this.contentResolver.openFileDescriptor(uri, "w")//"w", "r", "rwt"

            val fileOutputStream = FileOutputStream(parcelFileDescriptor?.fileDescriptor)
            fileOutputStream.write(fileContent.toByteArray())
            fileOutputStream.close()
            parcelFileDescriptor?.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun updateFile(uri: Uri, content: String) {
        try {
            val parcelFileDescriptor = this.contentResolver.openFileDescriptor(uri, "rwt")
            val fileOutputStream = FileOutputStream(parcelFileDescriptor?.fileDescriptor)
            fileOutputStream.write(content.toByteArray())
            fileOutputStream.close()
            parcelFileDescriptor?.close()
        } catch (e:Exception) {
            e.printStackTrace()
        }
    }

    fun deleteFile() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "text/*"

        deleteFile.launch(intent)

    }

    fun deleteFile(uri: Uri) {
        var cursor: Cursor? = null
        try {
            cursor = this.contentResolver.query(uri, null, null, null, null)
            if (cursor != null && cursor.moveToFirst()){
                DocumentsContract.deleteDocument(this.contentResolver, uri)
            }
        } catch (e:Exception) {
            e.printStackTrace()
        } finally {
            cursor?.close()
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        var fileName = ""

        Column(
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Yellow), horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
            Spacer(modifier = Modifier.padding(10.dp))
            MyTextField("Enter File Name") { s: String, i: Int ->
                fileName = s
            }
            Spacer(modifier = Modifier.padding(10.dp))
            MyTextField("Enter File Content") { s: String, i: Int ->
                fileContent = s
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = {
                createFile(fileName)
            }) {
                Text(text = "Save File")
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "Hello $name!",
                modifier = modifier
            )

            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = {
                readFile()
            }) {
                Text(text = "Read File")
            }


        }

    }

    @Composable
    fun MyTextField(textLabel: String, callback: (value: String, i: Int) -> Unit) {
        val state = remember {
            mutableStateOf("")
        }

        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
//                val previousValue = callback.invoke(state.value, state.value.length)
                callback.invoke(state.value, state.value.length)
//                val previousValue = callback.invoke(state.value)

//                Log.d(TAG, "MyTextField: $it, previousValue: $previousValue")
                Log.d(TAG, "MyTextField: $it")
            },
            label = {
                Text(text = textLabel)
            },
            placeholder = {
                Text(text = "placeholder")
            }
        )
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        AndroidKotlinJavaDsWorkbenchTheme {
            Greeting("Android")
        }
    }
}








