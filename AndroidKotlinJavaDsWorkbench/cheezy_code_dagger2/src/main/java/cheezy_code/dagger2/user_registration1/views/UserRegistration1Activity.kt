package cheezy_code.dagger2.user_registration1.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cheezy_code.dagger2.R
import cheezy_code.dagger2.user_registration1.services.UserRegistrationService1

class UserRegistration1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userRegistrationService1 = UserRegistrationService1()
        userRegistrationService1.registerUser("zyx@abc.com", "123456789")
    }
}