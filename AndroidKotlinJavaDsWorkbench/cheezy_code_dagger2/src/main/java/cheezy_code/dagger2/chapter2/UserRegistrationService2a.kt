package cheezy_code.dagger2.chapter2

class UserRegistrationService2a {
    private val userRepository = UserRepository2()
    private val emailService = EmailService2()

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