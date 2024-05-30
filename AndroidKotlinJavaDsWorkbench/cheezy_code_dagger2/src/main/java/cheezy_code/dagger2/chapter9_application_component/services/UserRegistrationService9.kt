package cheezy_code.dagger2.chapter9_application_component.services

import cheezy_code.dagger2.chapter10_component_dependencies.services.NotificationService9
import cheezy_code.dagger2.chapter10_component_dependencies.UserRepository9
import javax.inject.Inject
import javax.inject.Named

class UserRegistrationService9 @Inject constructor(
    private val userRepository: UserRepository9,
    @Named("email") private val notificationService: NotificationService9
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}
