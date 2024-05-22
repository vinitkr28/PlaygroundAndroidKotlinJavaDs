package cheezy_code.dagger2.chapter6

import javax.inject.Inject
import javax.inject.Named

class UserRegistrationService6 @Inject constructor(
    private val userRepository: UserRepository6,
    @Named("email") private val notificationService: NotificationService6
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}
