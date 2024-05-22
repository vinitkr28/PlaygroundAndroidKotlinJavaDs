package cheezy_code.dagger2.chapter6

import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRepository"


interface UserRepository6 {
    fun saveUser(email: String, password: String)
}

class SQLRepository6 @Inject constructor() : UserRepository6 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in DB")
    }
}

class FirebaseRepository6 : UserRepository6 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in Firebase")
    }
}