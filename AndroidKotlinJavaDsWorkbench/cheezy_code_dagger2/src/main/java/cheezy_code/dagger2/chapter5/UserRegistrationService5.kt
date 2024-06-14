package cheezy_code.dagger2.chapter5

import javax.inject.Inject

class UserRegistrationService5 @Inject constructor(
    private val userRepository: UserRepository5,
    private val notificationService: NotificationService5
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}
