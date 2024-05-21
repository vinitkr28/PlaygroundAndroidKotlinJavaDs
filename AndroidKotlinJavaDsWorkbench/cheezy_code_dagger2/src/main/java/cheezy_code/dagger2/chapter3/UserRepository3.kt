package cheezy_code.dagger2.chapter3

import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRepository"
class UserRepository3 @Inject constructor(){

    fun saveUser(email: String, password: String) {
        Log.d(TAG, "User Saved in DB")
    }
}