package cheezy_code.dagger2.user_registration5_provider_binder

import javax.inject.Inject

interface NotificationService5 {
    fun send(email: String, emailId: String, emailBody: String)
}

class EmailService5 @Inject constructor(): NotificationService5 {

    override fun send(to: String, from: String, emailBody: String) {
        println("Email sent")
    }
}


class MessageService5 @Inject constructor(): NotificationService5 {

    override fun send(to: String, from: String, emailBody: String) {
        println("message sent")
    }
}