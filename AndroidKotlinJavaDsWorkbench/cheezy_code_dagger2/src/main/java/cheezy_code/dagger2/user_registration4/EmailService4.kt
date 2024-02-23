package cheezy_code.dagger2.user_registration4

import javax.inject.Inject

class EmailService4 @Inject constructor() {

    fun send(email: String, emailId: String, emailBody: String) {
        println("Email sent")
    }
}