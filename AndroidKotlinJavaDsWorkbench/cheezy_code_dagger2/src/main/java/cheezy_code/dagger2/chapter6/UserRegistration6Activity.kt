package cheezy_code.dagger2.chapter6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cheezy_code.dagger2.R
import javax.inject.Inject

class UserRegistration6Activity : AppCompatActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService6

    @Inject
    lateinit var emailService: EmailService6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

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



        /*
        val component = DaggerUserRegistrationComponent5.builder().build()
        component.inject(this)

        *//*val userRegistrationService = component.getUserRegistrationService()
        val emailService = component.getEmailService()*//*

        emailService.send("", "", null)

        userRegistrationService.registerUser("abc@xyz.com", "1234567890")
        */

    }
}