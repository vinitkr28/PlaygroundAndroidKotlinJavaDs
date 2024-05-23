package cheezy_code.dagger2.chapter8_singleton

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule8WithMessageQualifier(private val retryCount: Int) {


    @MessageQualifier8
    @Provides
    fun getMessageService(): NotificationService8 {
        return MessageService8(retryCount)
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
    fun getEmailService(emailService: EmailService8): NotificationService8 {
        return emailService
    }
}