package cheezy_code.dagger2.chapter3

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