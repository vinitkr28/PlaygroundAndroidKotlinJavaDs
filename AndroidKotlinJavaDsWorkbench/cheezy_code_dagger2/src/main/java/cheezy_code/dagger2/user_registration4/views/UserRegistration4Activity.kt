package cheezy_code.dagger2.user_registration4.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cheezy_code.dagger2.R
import cheezy_code.dagger2.user_registration4.DaggerUserRegistrationComponent4
import cheezy_code.dagger2.user_registration4.EmailService4
import cheezy_code.dagger2.user_registration4.services.UserRegistrationService4
import javax.inject.Inject

class UserRegistration4Activity : AppCompatActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService4

    @Inject
    lateinit var emailService: EmailService4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        //Example 1:
        val component = DaggerUserRegistrationComponent4.builder().build()

        val userRegistrationService = component.getUserRegistrationService()
        val emailService = component.getEmailService()

        userRegistrationService.registerUser("zyx@abc.com", "123456789")
        */


        val component = DaggerUserRegistrationComponent4.builder().build()
        component.inject(this)

        userRegistrationService.registerUser("zyx@abc.com", "123456789")

        emailService.send("abc ayz", "", "")

    }
}