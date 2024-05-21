package cheezy_code.dagger2.chapter2

import cheezy_code.dagger2.chapter3.EmailService3
import cheezy_code.dagger2.chapter3.UserRepository3

class UserRegistrationService2b(
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