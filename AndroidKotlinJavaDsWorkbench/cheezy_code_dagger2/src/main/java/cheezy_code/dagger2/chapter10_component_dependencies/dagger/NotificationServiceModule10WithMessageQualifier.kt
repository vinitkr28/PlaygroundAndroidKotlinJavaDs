package cheezy_code.dagger2.chapter10_component_dependencies.dagger

import cheezy_code.dagger2.chapter10_component_dependencies.services.EmailService10
import cheezy_code.dagger2.chapter10_component_dependencies.services.MessageService10
import cheezy_code.dagger2.chapter10_component_dependencies.services.NotificationService10
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule10WithMessageQualifier(private val retryCount: Int) {


    @MessageQualifier10
    @Provides
    fun getMessageService(): NotificationService10 {
        return MessageService10(retryCount)
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
    fun getEmailService(emailService: EmailService10): NotificationService10 {
        return emailService
    }
}