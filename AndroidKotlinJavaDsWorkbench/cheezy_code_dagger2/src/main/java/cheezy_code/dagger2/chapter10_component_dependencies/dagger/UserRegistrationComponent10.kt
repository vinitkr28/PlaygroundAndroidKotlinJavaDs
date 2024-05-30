package cheezy_code.dagger2.chapter10_component_dependencies.dagger

import cheezy_code.dagger2.chapter10_component_dependencies.views.UserRegistration10Activity
import dagger.Component

@Component(modules = [UserRepositoryModule10::class, NotificationServiceModule10WithMessageQualifier::class])
interface UserRegistrationComponent10 {
    /*
    fun getUserRegistrationService(): UserRegistrationService4

    fun getEmailService(): EmailService3
    */

    fun inject(userRegistration10Activity: UserRegistration10Activity)
}