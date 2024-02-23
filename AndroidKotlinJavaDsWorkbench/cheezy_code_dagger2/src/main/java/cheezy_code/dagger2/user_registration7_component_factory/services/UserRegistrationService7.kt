package cheezy_code.dagger2.user_registration7_component_factory.services

import cheezy_code.dagger2.user_registration7_component_factory.NotificationService7
import cheezy_code.dagger2.user_registration7_component_factory.UserRepository7
import cheezy_code.dagger2.user_registration7_component_factory.dagger.MessageQualifier7
import javax.inject.Inject
import javax.inject.Named


class UserRegistrationService7 @Inject constructor(
    private val userRepository: UserRepository7,
    @MessageQualifier7 private val notificationService: NotificationService7
) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}