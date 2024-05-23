package cheezy_code.dagger2.chapter9_application_component

import cheezy_code.dagger2.chapter9_application_component.EmailService9
import cheezy_code.dagger2.chapter9_application_component.MessageQualifier9
import cheezy_code.dagger2.chapter9_application_component.MessageService9
import cheezy_code.dagger2.chapter9_application_component.NotificationService9
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