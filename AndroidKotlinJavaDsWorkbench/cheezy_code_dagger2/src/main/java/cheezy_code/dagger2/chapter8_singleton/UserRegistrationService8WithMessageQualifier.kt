package cheezy_code.dagger2.chapter8_singleton

import javax.inject.Inject
import javax.inject.Named

class UserRegistrationService8WithMessageQualifier @Inject constructor(
    private val userRepository: UserRepository8,
    @MessageQualifier8 private val notificationService: NotificationService8
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}
