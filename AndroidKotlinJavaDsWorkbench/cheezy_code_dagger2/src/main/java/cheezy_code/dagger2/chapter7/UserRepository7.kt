package cheezy_code.dagger2.chapter7

import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRepository"


interface UserRepository7 {
    fun saveUser(email: String, password: String)
}

class SQLRepository7 @Inject constructor() : UserRepository7 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in DB")
    }
}

class FirebaseRepository7 : UserRepository7 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in Firebase")
    }
}