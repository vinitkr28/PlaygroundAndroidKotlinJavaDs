package cheezy_code.dagger2.chapter9_application_component

import javax.inject.Inject

class UserRegistrationService9WithMessageQualifier @Inject constructor(
    private val userRepository: UserRepository9,
    @MessageQualifier9 private val notificationService: NotificationService9
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}
