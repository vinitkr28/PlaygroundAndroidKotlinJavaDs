package cheezy_code.dagger2.chapter8_singleton

import dagger.Component

@Component(modules = [UserRepositoryModule8::class, NotificationServiceModule8WithMessageQualifier::class])
interface UserRegistrationComponent8 {
    /*
    fun getUserRegistrationService(): UserRegistrationService4

    fun getEmailService(): EmailService3
    */

    fun inject(userRegistration8Activity: UserRegistration8Activity)
}