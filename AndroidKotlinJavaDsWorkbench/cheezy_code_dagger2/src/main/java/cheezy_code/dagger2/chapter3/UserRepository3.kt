package cheezy_code.dagger2.chapter2

import android.util.Log

private const val TAG = "UserRepository"
class UserRepository3 {

    fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in DB")
    }
}