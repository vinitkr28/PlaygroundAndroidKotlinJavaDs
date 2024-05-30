package cheezy_code.dagger2.chapter10_component_dependencies

import android.app.Application
import cheezy_code.dagger2.chapter10_component_dependencies.dagger.DaggerUserRegistrationComponent10WithFactory
import cheezy_code.dagger2.chapter10_component_dependencies.dagger.UserRegistrationComponent10WithFactory

class UserApplication10: Application() {

    lateinit var userRegistrationComponent: UserRegistrationComponent10WithFactory

    override fun onCreate() {
        super.onCreate()

        userRegistrationComponent = DaggerUserRegistrationComponent10WithFactory.factory().create(78)
    }
}