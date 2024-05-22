package cheezy_code.dagger2.chapter5

import android.util.Log
import javax.inject.Inject

private const val TAG = "EmailService"

interface NotificationService5 {
    fun send(to: String, from: String, body: String?)
}
class EmailService5 @Inject constructor(): NotificationService5 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}

class MessageService5 @Inject constructor(): NotificationService5 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent")
    }
}