package cheezy_code.dagger2.chapter4

import javax.inject.Inject

class UserRegistrationService4 @Inject constructor(
    private val userRepository: UserRepository4,
    private val notificationService: NotificationService4
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}
