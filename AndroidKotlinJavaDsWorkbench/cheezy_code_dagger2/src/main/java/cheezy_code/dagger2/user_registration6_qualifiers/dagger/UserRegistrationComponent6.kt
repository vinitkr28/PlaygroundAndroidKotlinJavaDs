package cheezy_code.dagger2.user_registration6_qualifiers.dagger

import cheezy_code.dagger2.user_registration6_qualifiers.views.UserRegistration6Activity
import dagger.Component

@Component(modules = [UserRepositoryModule6::class, NotificationServiceModule6::class])
internal interface UserRegistrationComponent6 {


    fun inject(userRegistration6Activity: UserRegistration6Activity)
}