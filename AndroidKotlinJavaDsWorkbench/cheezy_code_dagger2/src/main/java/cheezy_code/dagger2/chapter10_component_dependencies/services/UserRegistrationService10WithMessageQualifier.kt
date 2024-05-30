package cheezy_code.dagger2.chapter10_component_dependencies.services

import cheezy_code.dagger2.chapter10_component_dependencies.UserRepository10
import cheezy_code.dagger2.chapter10_component_dependencies.dagger.MessageQualifier10
import cheezy_code.dagger2.chapter9_application_component.services.NotificationService9
import javax.inject.Inject

class UserRegistrationService10WithMessageQualifier @Inject constructor(
    private val userRepository: UserRepository10,
    @MessageQualifier10 private val notificationService: NotificationService9
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "abc@xyz.com", "user registered")
    }
}
