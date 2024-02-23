package cheezy_code.dagger2.user_registration7_component_factory.dagger

import cheezy_code.dagger2.user_registration7_component_factory.views.UserRegistration7Activity
import dagger.Component

@Component(modules = [UserRepositoryModule7::class, NotificationServiceModule7::class])
internal interface UserRegistrationComponent7 {


    fun inject(userRegistration7Activity: UserRegistration7Activity)
}