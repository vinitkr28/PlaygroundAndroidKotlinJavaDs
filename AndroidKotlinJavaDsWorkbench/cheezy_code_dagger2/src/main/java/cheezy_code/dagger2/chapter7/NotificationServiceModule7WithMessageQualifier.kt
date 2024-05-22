package cheezy_code.dagger2.chapter7

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule7WithMessageQualifier {

    @MessageQualifier6
    @Provides
    fun getMessageService(): NotificationService6 {
        return MessageService7()
    }

    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService7): NotificationService7 {
        return emailService
    }
}