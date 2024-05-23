package cheezy_code.dagger2.chapter9_application_component.dagger

import cheezy_code.dagger2.chapter9_application_component.views.UserRegistration9Activity
import dagger.Component

@Component(modules = [UserRepositoryModule9::class, NotificationServiceModule9WithMessageQualifier::class])
interface UserRegistrationComponent9 {
    /*
    fun getUserRegistrationService(): UserRegistrationService4

    fun getEmailService(): EmailService3
    */

    fun inject(userRegistration9Activity: UserRegistration9Activity)
}