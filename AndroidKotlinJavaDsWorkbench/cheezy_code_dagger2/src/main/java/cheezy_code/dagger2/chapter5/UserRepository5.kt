package cheezy_code.dagger2.chapter5

import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRepository"


interface UserRepository5 {
    fun saveUser(email: String, password: String)
}

class SQLRepository5 @Inject constructor() : UserRepository5 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in DB")
    }
}

class FirebaseRepository5 : UserRepository5 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in Firebase")
    }
}