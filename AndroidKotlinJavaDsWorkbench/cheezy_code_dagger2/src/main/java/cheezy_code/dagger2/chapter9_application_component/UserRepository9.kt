package cheezy_code.dagger2.chapter9_application_component

import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRepository"


interface UserRepository9 {
    fun saveUser(email: String, password: String)
}

class SQLRepository9 @Inject constructor() : UserRepository9 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in DB")
    }
}

class FirebaseRepository9 : UserRepository9 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in Firebase")
    }
}