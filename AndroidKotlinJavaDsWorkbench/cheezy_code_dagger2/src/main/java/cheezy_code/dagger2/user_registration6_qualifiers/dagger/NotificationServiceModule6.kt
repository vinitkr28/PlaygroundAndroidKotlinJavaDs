package cheezy_code.dagger2.user_registration6_qualifiers.dagger

import cheezy_code.dagger2.user_registration6_qualifiers.EmailService6
import cheezy_code.dagger2.user_registration6_qualifiers.MessageService6
import cheezy_code.dagger2.user_registration6_qualifiers.NotificationService6
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule6 {

    /*@Named("message")
    @Provides
    fun getMessageService(): NotificationService6 {
        return MessageService6()
    }*/


    @MessageQualifier
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