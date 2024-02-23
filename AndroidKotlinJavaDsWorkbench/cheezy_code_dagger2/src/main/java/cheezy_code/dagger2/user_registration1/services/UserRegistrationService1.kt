package cheezy_code.dagger2.user_registration1.services

import cheezy_code.dagger2.user_registration1.EmailService1
import cheezy_code.dagger2.user_registration1.UserRepository1

class UserRegistrationService1 {
    private val userRepository = UserRepository1()
    private val emailService = EmailService1()

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