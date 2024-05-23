package cheezy_code.dagger2.chapter8_singleton

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule8WithMessageQualifierWithFactory() {


    @MessageQualifier8
    @Provides
    fun getMessageService(retryCount: Int): NotificationService8 {
        return MessageService8(retryCount)
    }


    /*
    @MessageQualifier8
    @Provides
    fun getMessageService(): NotificationService8 {
        return MessageService8(5)
    }
    */

    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService8): NotificationService8 {
        return emailService
    }
}