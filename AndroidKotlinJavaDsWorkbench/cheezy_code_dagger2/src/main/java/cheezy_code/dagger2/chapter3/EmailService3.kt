package cheezy_code.dagger2.chapter3

import android.util.Log
import javax.inject.Inject

private const val TAG = "EmailService"
class EmailService3 @Inject constructor() {

    fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}