package cheezy_code.dagger2.chapter4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cheezy_code.dagger2.R
import cheezy_code.dagger2.chapter3.DaggerUserRegistrationComponent3

class UserRegistration4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        /*
        val userRegistrationService2a = UserRegistrationService2a()
        userRegistrationService2a.registerUser("abc@xyz.com", "1234567890")
        */


        /*
        val emailService2 = EmailService3()
        val userRepository2 = UserRepository3()

        val userRegistrationService2b = UserRegistrationService3(
            emailService = emailService2,
            userRepository = userRepository2
        )
        userRegistrationService2b.registerUser("abc@xyz.com", "1234567890")
        */

        val component = DaggerUserRegistrationComponent3.builder().build()

        val userRegistrationService = component.getUserRegistrationService()
        val emailService = component.getEmailService()

        userRegistrationService.registerUser("abc@xyz.com", "1234567890")

    }
}