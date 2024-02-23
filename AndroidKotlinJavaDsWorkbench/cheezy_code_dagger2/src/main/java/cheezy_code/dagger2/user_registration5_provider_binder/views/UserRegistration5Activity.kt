package cheezy_code.dagger2.user_registration5_provider_binder.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cheezy_code.dagger2.R
import cheezy_code.dagger2.user_registration5_provider_binder.EmailService5
import cheezy_code.dagger2.user_registration5_provider_binder.dagger.DaggerUserRegistrationComponent5
import cheezy_code.dagger2.user_registration5_provider_binder.services.UserRegistrationService5
import javax.inject.Inject

class UserRegistration5Activity : AppCompatActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService5

    @Inject
    lateinit var emailService: EmailService5
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


        val component = DaggerUserRegistrationComponent5.builder().build()
        component.inject(this)

        userRegistrationService.registerUser("zyx@abc.com", "123456789")

//        emailService.send("abc ayz", "", "")

    }
}