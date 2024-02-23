package cheezy_code.dagger2.user_registration5_provider_binder.dagger

import cheezy_code.dagger2.user_registration5_provider_binder.views.UserRegistration5Activity
import dagger.Component

@Component(modules = [UserRepositoryModule5::class, NotificationServiceModule5::class])
internal interface UserRegistrationComponent5 {

    /*
    //Example 1.
    fun getUserRegistrationService(): UserRegistrationService4

    fun getEmailService(): EmailService4
*/

    fun inject(userRegistration5Activity: UserRegistration5Activity)
}