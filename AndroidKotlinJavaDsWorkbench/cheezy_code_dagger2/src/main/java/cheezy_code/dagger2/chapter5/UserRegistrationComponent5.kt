package cheezy_code.dagger2.chapter5

import dagger.Component

//@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
@Component(modules = [UserRepositoryModuleWithBind5::class, NotificationServiceModule5::class])
interface UserRegistrationComponent5 {
    /*
    fun getUserRegistrationService(): UserRegistrationService4

    fun getEmailService(): EmailService3
    */

    fun inject(userRegistration5Activity: UserRegistration5Activity)
}