package cheezy_code.dagger2.chapter6

import dagger.Component

@Component(modules = [UserRepositoryModule6::class, NotificationServiceModule6WithMessageQualifier::class])
interface UserRegistrationComponent5 {
    /*
    fun getUserRegistrationService(): UserRegistrationService4

    fun getEmailService(): EmailService3
    */

    fun inject(userRegistration6Activity: UserRegistration6Activity)
}