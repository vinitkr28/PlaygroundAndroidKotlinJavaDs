package cheezy_code.dagger2.chapter2

import android.util.Log

private const val TAG = "EmailService"
class EmailService2 {

    fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}