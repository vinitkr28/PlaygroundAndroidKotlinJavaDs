package cheezy_code.dagger2.user_registration6_qualifiers.services

import cheezy_code.dagger2.user_registration6_qualifiers.NotificationService6
import cheezy_code.dagger2.user_registration6_qualifiers.UserRepository6
import cheezy_code.dagger2.user_registration6_qualifiers.dagger.MessageQualifier
import javax.inject.Inject

/*

class UserRegistrationService6 @Inject constructor(
    private val userRepository: UserRepository6,
    @Named("message") private val notificationService: NotificationService6
) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}

*/



class UserRegistrationService6 @Inject constructor(
    private val userRepository: UserRepository6,
    @MessageQualifier private val notificationService: NotificationService6
) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}