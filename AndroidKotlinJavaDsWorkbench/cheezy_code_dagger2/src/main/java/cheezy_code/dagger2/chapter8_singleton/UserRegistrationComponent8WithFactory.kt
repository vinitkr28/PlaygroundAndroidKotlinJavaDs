package cheezy_code.dagger2.chapter8_singleton

import dagger.BindsInstance
import dagger.Component

@Component(modules = [UserRepositoryModule8::class, NotificationServiceModule8WithMessageQualifierWithFactory::class])
interface UserRegistrationComponent8WithFactory {

    fun inject(userRegistration7Activity: UserRegistration8Activity)


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance retryCount: Int): UserRegistrationComponent8WithFactory
    }
}