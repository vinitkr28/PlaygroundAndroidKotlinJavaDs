package cheezy_code.dagger2.chapter9_application_component.services

import android.util.Log
import cheezy_code.dagger2.chapter9_application_component.dagger.ApplicationScope9
import javax.inject.Inject

private const val TAG = "NotificationService9"

interface NotificationService9 {
    fun send(to: String, from: String, body: String?)
}

@ApplicationScope9
class EmailService9 @Inject constructor() : NotificationService9 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}

class MessageService9(private val retryCount: Int) : NotificationService9 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent - Retry Count $retryCount")
    }
}