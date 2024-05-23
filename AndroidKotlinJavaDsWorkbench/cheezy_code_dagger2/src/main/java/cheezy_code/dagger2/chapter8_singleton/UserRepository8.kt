package cheezy_code.dagger2.chapter8_singleton

import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRepository"


interface UserRepository8 {
    fun saveUser(email: String, password: String)
}

class SQLRepository8 @Inject constructor() : UserRepository8 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in DB")
    }
}

class FirebaseRepository8 : UserRepository8 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in Firebase")
    }
}