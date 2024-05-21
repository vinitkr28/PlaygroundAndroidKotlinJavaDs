package cheezy_code.dagger2.chapter4

import dagger.Component

@Component
interface UserRegistrationComponent4 {
    /*
    fun getUserRegistrationService(): UserRegistrationService4

    fun getEmailService(): EmailService3
    */

    fun inject(userRegistration4Activity: UserRegistration4Activity)
}