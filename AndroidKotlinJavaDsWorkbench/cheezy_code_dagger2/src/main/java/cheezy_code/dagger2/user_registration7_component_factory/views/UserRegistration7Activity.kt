package cheezy_code.dagger2.user_registration7_component_factory.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cheezy_code.dagger2.R
import cheezy_code.dagger2.user_registration7_component_factory.EmailService7
import cheezy_code.dagger2.user_registration7_component_factory.dagger.DaggerUserRegistrationComponent7
import cheezy_code.dagger2.user_registration7_component_factory.services.UserRegistrationService7
import javax.inject.Inject

class UserRegistration7Activity : AppCompatActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService7

    @Inject
    lateinit var emailService: EmailService7
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


        val component = DaggerUserRegistrationComponent7.builder().build()
        component.inject(this)

        userRegistrationService.registerUser("zyx@abc.com", "123456789")

//        emailService.send("abc ayz", "", "")

    }
}