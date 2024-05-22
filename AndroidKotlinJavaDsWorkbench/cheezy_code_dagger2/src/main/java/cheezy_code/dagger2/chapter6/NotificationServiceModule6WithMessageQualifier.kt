package cheezy_code.dagger2.chapter6

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule6WithMessageQualifier {

    @MessageQualifier6
    @Provides
    fun getMessageService(): NotificationService6 {
        return MessageService6()
    }

    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService6): NotificationService6 {
        return emailService
    }
}