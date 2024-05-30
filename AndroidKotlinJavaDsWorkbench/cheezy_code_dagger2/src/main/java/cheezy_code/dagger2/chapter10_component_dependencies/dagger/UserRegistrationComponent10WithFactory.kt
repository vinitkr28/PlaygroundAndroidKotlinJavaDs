package cheezy_code.dagger2.chapter10_component_dependencies.dagger

import cheezy_code.dagger2.chapter10_component_dependencies.views.UserRegistration10Activity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope10
@Component(modules = [UserRepositoryModule10::class, NotificationServiceModule10WithMessageQualifierWithFactory::class])
interface UserRegistrationComponent10WithFactory {

    fun inject(userRegistration10Activity: UserRegistration10Activity)


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance retryCount: Int): UserRegistrationComponent10WithFactory
    }
}