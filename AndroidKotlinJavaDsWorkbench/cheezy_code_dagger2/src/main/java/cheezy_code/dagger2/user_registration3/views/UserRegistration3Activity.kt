package cheezy_code.dagger2.user_registration3.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cheezy_code.dagger2.R
import cheezy_code.dagger2.user_registration3.DaggerUserRegistrationComponent3

class UserRegistration3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userRegistrationService = DaggerUserRegistrationComponent3.builder().build().getUserRegistrationService()
        userRegistrationService.registerUser("zyx@abc.com", "123456789")
    }
}