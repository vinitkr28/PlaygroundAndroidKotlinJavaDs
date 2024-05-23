package cheezy_code.dagger2.chapter7

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule7WithMessageQualifier(private val retryCount: Int) {


    @MessageQualifier7
    @Provides
    fun getMessageService(): NotificationService7 {
        return MessageService7(retryCount)
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
    fun getEmailService(emailService: EmailService7): NotificationService7 {
        return emailService
    }
}