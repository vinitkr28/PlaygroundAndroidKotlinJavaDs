package cheezy_code.dagger2.user_registration2.services

import cheezy_code.dagger2.user_registration2.EmailService2
import cheezy_code.dagger2.user_registration2.UserRepository2

class UserRegistrationService2(
    private val userRepository: UserRepository2,
    private val emailService: EmailService2
) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "abc@xyz.com", "user registered")
    }
}