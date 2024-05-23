package cheezy_code.dagger2.chapter7

import dagger.BindsInstance
import dagger.Component

@Component(modules = [UserRepositoryModule7::class, NotificationServiceModule7WithMessageQualifierWithFactory::class])
interface UserRegistrationComponent7WithFactory {

    fun inject(userRegistration7Activity: UserRegistration7Activity)


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance retryCount: Int): UserRegistrationComponent7WithFactory
    }
}