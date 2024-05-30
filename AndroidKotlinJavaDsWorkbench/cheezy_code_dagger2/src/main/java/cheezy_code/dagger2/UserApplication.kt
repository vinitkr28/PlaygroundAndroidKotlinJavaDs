package cheezy_code.dagger2

import android.app.Application
import cheezy_code.dagger2.chapter9_application_component.DaggerUserRegistrationComponent9WithFactory
import cheezy_code.dagger2.chapter10_component_dependencies.dagger.UserRegistrationComponent9WithFactory

class UserApplication: Application() {

    lateinit var userRegistrationComponent: UserRegistrationComponent9WithFactory

    override fun onCreate() {
        super.onCreate()

        userRegistrationComponent = DaggerUserRegistrationComponent9WithFactory.factory().create(78)
    }
}