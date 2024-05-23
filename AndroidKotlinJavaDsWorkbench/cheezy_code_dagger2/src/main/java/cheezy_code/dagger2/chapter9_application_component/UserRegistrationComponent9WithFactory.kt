package cheezy_code.dagger2.chapter9_application_component

import dagger.BindsInstance
import dagger.Component

@Component(modules = [UserRepositoryModule9::class, NotificationServiceModule9WithMessageQualifierWithFactory::class])
interface UserRegistrationComponent9WithFactory {

    fun inject(userRegistration9Activity: UserRegistration9Activity)


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance retryCount: Int): UserRegistrationComponent9WithFactory
    }
}