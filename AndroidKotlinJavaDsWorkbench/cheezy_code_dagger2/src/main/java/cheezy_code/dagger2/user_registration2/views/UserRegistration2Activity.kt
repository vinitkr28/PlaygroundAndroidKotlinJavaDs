package cheezy_code.dagger2.user_registration2.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cheezy_code.dagger2.R
import cheezy_code.dagger2.user_registration2.EmailService2
import cheezy_code.dagger2.user_registration2.UserRepository2
import cheezy_code.dagger2.user_registration2.services.UserRegistrationService2

class UserRegistration2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val userRepository = UserRepository2()
        val emailService = EmailService2()

        val userRegistrationService = UserRegistrationService2(userRepository, emailService)
        userRegistrationService.registerUser("zyx@abc.com", "123456789")
    }
}

/*
*as a developer we tell dagger to things:
* how to create an object
* where we can consume the object
*
* */