package com.philipp_lackner.cleanCodeHacks.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.philipp_lackner.cleanCodeHacks.hack3.sharedPreferences


/*
* https://www.youtube.com/watch?v=MbIB8J5_zjM&t=4s
* 3 Clean Code Hacks I Bet You Didn't Know (Kotlin & Android)
* Philipp Lackner
* */
class SecondActivity : ComponentActivity() {
/*
    private val sharedPreferences by lazy {
        getSharedPreferences("my_prefs", MODE_PRIVATE)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences.edit().putString("token", "Hello world").apply()


        val token = sharedPreferences.getString("token", null)


// We will use property delegate. With the help of this we can override getter and setter of a simple property.

        println(token)


        setContent {

        }
    }
    */



    private var state by mutableStateOf(0)
    private var state2 = mutableStateOf(0)


    private var token by sharedPreferences("token")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        token = "Hello from Second Activity"

        println(token)

        state++
        //state2++//state2 is type of state2: MutableState<Int>
        state2.value++

        setContent {

        }
    }
}
