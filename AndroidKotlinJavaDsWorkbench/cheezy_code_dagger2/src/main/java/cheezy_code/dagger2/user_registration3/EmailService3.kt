package cheezy_code.dagger2.user_registration3

import javax.inject.Inject

class EmailService3 @Inject constructor() {

    fun send(email: String, emailId: String, emailBody: String) {
        println("Email sent")
    }
}