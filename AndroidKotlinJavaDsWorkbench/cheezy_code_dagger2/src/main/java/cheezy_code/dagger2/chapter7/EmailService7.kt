package cheezy_code.dagger2.chapter7

import android.util.Log
import javax.inject.Inject

private const val TAG = "NotificationService7"

interface NotificationService7 {
    fun send(to: String, from: String, body: String?)
}

class EmailService7 @Inject constructor() : NotificationService7 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}

class MessageService7(private val retryCount: Int) : NotificationService7 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent - Retry Count $retryCount")
    }
}