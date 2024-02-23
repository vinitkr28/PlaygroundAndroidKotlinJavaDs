package cheezy_code.dagger2.user_registration7_component_factory

import javax.inject.Inject

interface NotificationService7 {
    fun send(email: String, emailId: String, emailBody: String)
}

class EmailService7 @Inject constructor(): NotificationService7 {

    override fun send(to: String, from: String, emailBody: String) {
        println("Email sent")
    }
}


class MessageService7 @Inject constructor(): NotificationService7 {

    override fun send(to: String, from: String, emailBody: String) {
        println("message sent")
    }
}