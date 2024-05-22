package cheezy_code.dagger2.chapter7

import dagger.Component

@Component(modules = [UserRepositoryModule7::class, NotificationServiceModule7WithMessageQualifier::class])
interface UserRegistrationComponent7 {
    /*
    fun getUserRegistrationService(): UserRegistrationService4

    fun getEmailService(): EmailService3
    */

    fun inject(userRegistration7Activity: UserRegistration7Activity)
}