package cheezy_code.dagger2.chapter10_component_dependencies.services

import cheezy_code.dagger2.chapter10_component_dependencies.UserRepository10
import javax.inject.Inject
import javax.inject.Named

class UserRegistrationService10 @Inject constructor(
    private val userRepository: UserRepository10,
    @Named("email") private val notificationService: NotificationService10
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}
