package cheezy_code.dagger2.chapter7

import javax.inject.Inject
import javax.inject.Named

class UserRegistrationService7WithMessageQualifier @Inject constructor(
    private val userRepository: UserRepository7,
    @MessageQualifier7 private val notificationService: NotificationService7
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}
