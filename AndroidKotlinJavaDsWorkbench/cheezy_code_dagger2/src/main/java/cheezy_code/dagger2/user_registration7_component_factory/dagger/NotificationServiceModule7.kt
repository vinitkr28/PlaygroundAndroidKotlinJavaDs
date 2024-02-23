package cheezy_code.dagger2.user_registration7_component_factory.dagger

import cheezy_code.dagger2.user_registration7_component_factory.EmailService7
import cheezy_code.dagger2.user_registration7_component_factory.MessageService7
import cheezy_code.dagger2.user_registration7_component_factory.NotificationService7
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule7 {

    /*@Named("message")
    @Provides
    fun getMessageService(): NotificationService6 {
        return MessageService6()
    }*/


    @MessageQualifier7
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