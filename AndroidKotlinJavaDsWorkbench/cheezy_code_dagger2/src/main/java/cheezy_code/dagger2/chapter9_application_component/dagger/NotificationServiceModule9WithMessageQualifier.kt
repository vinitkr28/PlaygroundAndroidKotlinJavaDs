package cheezy_code.dagger2.chapter9_application_component.dagger

import cheezy_code.dagger2.chapter10_component_dependencies.services.EmailService9
import cheezy_code.dagger2.chapter10_component_dependencies.services.MessageService9
import cheezy_code.dagger2.chapter10_component_dependencies.services.NotificationService9
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule9WithMessageQualifier(private val retryCount: Int) {


    @MessageQualifier9
    @Provides
    fun getMessageService(): NotificationService9 {
        return MessageService9(retryCount)
    }


    /*
    @MessageQualifier7
    @Provides
    fun getMessageService(): NotificationService7 {
        return MessageService7(5)
    }
    */

    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService9): NotificationService9 {
        return emailService
    }
}