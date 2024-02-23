package cheezy_code.dagger2.user_registration6_qualifiers

import javax.inject.Inject

interface NotificationService6 {
    fun send(email: String, emailId: String, emailBody: String)
}

class EmailService6 @Inject constructor(): NotificationService6 {

    override fun send(to: String, from: String, emailBody: String) {
        println("Email sent")
    }
}


class MessageService6 @Inject constructor(): NotificationService6 {

    override fun send(to: String, from: String, emailBody: String) {
        println("message sent")
    }
}