package cheezy_code.dagger2.chapter10_component_dependencies.services

import android.util.Log
import cheezy_code.dagger2.chapter10_component_dependencies.dagger.ApplicationScope10
import javax.inject.Inject

private const val TAG = "NotificationService10"

interface NotificationService10 {
    fun send(to: String, from: String, body: String?)
}

@ApplicationScope10
class EmailService10 @Inject constructor() : NotificationService10 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}

class MessageService10(private val retryCount: Int) : NotificationService10 {

    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent - Retry Count $retryCount")
    }
}