package cheezy_code.dagger2.chapter7

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule7 {

    @Named("message")
    @Provides
    fun getMessageService(): NotificationService7 {
        return MessageService7()
    }

    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService7): NotificationService7 {
        return emailService
    }
}