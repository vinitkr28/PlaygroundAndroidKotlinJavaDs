package cheezy_code.dagger2.chapter4

import cheezy_code.dagger2.chapter3.EmailService3
import dagger.Component

@Component
interface UserRegistrationComponent4 {
    fun getUserRegistrationService(): UserRegistrationService4

    fun getEmailService(): EmailService3
}