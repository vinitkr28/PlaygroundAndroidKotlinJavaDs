package cheezy_code.dagger2.chapter4

import android.util.Log
import javax.inject.Inject

private const val TAG = "EmailService"

interface NotificationService4 {
    fun send(to: String, from: String, body: String?)
}
class EmailService4 @Inject constructor(): NotificationService4 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}

class MessageService4 @Inject constructor(): NotificationService4 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent")
    }
}