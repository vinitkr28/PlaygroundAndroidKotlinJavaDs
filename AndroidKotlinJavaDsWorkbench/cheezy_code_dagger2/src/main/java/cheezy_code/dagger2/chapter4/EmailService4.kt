package cheezy_code.dagger2.chapter4

import android.util.Log
import javax.inject.Inject

private const val TAG = "EmailService"
class EmailService4 @Inject constructor() {

    fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}