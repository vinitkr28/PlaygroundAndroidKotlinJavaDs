package cheezy_code.dagger2.chapter9_application_component

import android.app.Application
import cheezy_code.dagger2.chapter9_application_component.dagger.UserRegistrationComponent9WithFactory

class UserApplication: Application() {

    lateinit var userRegistrationComponent: UserRegistrationComponent9WithFactory

    override fun onCreate() {
        super.onCreate()

        userRegistrationComponent = DaggerUserRegistrationComponent9WithFactory.factory().create(78)
    }
}