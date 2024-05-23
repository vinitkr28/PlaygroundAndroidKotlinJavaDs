package cheezy_code.dagger2.chapter8_singleton

import javax.inject.Inject
import javax.inject.Named

class UserRegistrationService8 @Inject constructor(
    private val userRepository: UserRepository8,
    @Named("email") private val notificationService: NotificationService8
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}
