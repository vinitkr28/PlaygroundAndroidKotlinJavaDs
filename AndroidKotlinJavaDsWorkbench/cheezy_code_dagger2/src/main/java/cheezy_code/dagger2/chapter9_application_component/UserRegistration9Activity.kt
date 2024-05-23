package cheezy_code.dagger2.chapter9_application_component

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cheezy_code.dagger2.R
import javax.inject.Inject

class UserRegistration9Activity : AppCompatActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService9

    @Inject
    lateinit var emailService: EmailService9

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

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


        /*
        * chapter7
        * */

        /*val component = DaggerUserRegistrationComponent7
            .builder()
            .notificationServiceModule7WithMessageQualifier(NotificationServiceModule7WithMessageQualifier(45))//if this will not set then it will break at runtime
            .build()*/

        /*
        val component = DaggerUserRegistrationComponent7WithFactory
            .builder()
            .notificationServiceModule7WithMessageQualifier(NotificationServiceModule7WithMessageQualifier(45))
            .build()
        */


        val component = DaggerUserRegistrationComponent9WithFactory
            .factory().create(33)
    }
}