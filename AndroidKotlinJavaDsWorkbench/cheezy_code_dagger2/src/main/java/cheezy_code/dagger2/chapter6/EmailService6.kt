package cheezy_code.dagger2.chapter6

import android.util.Log
import javax.inject.Inject

private const val TAG = "NotificationService6"

interface NotificationService6 {
    fun send(to: String, from: String, body: String?)
}

class EmailService6 @Inject constructor() : NotificationService6 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}

class MessageService6 : NotificationService6 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent")
    }
}