package cheezy_code.dagger2.user_registration3.services

import cheezy_code.dagger2.user_registration3.EmailService3
import cheezy_code.dagger2.user_registration3.UserRepository3
import javax.inject.Inject

class UserRegistrationService3 @Inject constructor(
    private val userRepository: UserRepository3,
    private val emailService: EmailService3
) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "abc@xyz.com", "user registered")
    }
}

/*
* Unit Testing
* Single Responsibility
* Lifetime of these objects
* Extensible
* */