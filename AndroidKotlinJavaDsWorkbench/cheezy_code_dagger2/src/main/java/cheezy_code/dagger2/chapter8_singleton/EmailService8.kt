package cheezy_code.dagger2.chapter8_singleton

import android.util.Log
import javax.inject.Inject

private const val TAG = "NotificationService8"

interface NotificationService8 {
    fun send(to: String, from: String, body: String?)
}

class EmailService8 @Inject constructor() : NotificationService8 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}

class MessageService8(private val retryCount: Int) : NotificationService8 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent - Retry Count $retryCount")
    }
}