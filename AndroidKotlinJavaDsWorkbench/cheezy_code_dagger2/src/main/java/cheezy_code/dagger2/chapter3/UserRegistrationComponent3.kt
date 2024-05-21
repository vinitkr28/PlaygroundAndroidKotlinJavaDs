package cheezy_code.dagger2.chapter3

import dagger.Component

@Component
interface UserRegistrationComponent3 {
    fun getUserRegistrationService(): UserRegistrationService3

    fun getEmailService(): EmailService3
}