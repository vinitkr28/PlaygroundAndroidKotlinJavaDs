package cheezy_code.dagger2.chapter4

import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRepository"


interface UserRepository4 {
    fun saveUser(email: String, password: String)
}

class SQLRepository4 @Inject constructor() : UserRepository4 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in DB")
    }
}

class FirebaseRepository4 @Inject constructor() : UserRepository4 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in Firebase")
    }
}