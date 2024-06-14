package cheezy_code.dagger2.chapter2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cheezy_code.dagger2.R
import cheezy_code.dagger2.chapter3.UserRepository3

class UserRegistration2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val userRegistrationService2a = UserRegistrationService2a()
        userRegistrationService2a.registerUser("abc@xyz.com", "1234567890")
        */


        val emailService2 = EmailService2()
        val userRepository2 = UserRepository2()

        val userRegistrationService2b = UserRegistrationService2b(
            emailService = emailService2,
            userRepository = userRepository2
        )
        userRegistrationService2b.registerUser("abc@xyz.com", "1234567890")

    }
}