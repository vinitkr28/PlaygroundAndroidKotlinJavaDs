package cheezy_code.dagger2.user_registration6_qualifiers.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cheezy_code.dagger2.R
import cheezy_code.dagger2.user_registration6_qualifiers.EmailService6
import cheezy_code.dagger2.user_registration6_qualifiers.dagger.DaggerUserRegistrationComponent6
import cheezy_code.dagger2.user_registration6_qualifiers.services.UserRegistrationService6
import javax.inject.Inject

class UserRegistration6Activity : AppCompatActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService6

    @Inject
    lateinit var emailService: EmailService6
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


        val component = DaggerUserRegistrationComponent6.builder().build()
        component.inject(this)

        userRegistrationService.registerUser("zyx@abc.com", "123456789")

//        emailService.send("abc ayz", "", "")

    }
}