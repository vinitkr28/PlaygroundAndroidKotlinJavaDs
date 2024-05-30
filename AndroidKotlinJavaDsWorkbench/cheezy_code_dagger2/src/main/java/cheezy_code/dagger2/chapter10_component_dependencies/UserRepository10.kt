package cheezy_code.dagger2.chapter10_component_dependencies

import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRepository"


interface UserRepository10 {
    fun saveUser(email: String, password: String)
}

class SQLRepository10 @Inject constructor() : UserRepository10 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in DB")
    }
}

class FirebaseRepository10 : UserRepository10 {

    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in Firebase")
    }
}