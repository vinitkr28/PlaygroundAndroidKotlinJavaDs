package cheezy_code.dagger2.user_registration3

import cheezy_code.dagger2.user_registration3.services.UserRegistrationService3
import dagger.Component

@Component
interface UserRegistrationComponent3 {

    fun getUserRegistrationService(): UserRegistrationService3
}