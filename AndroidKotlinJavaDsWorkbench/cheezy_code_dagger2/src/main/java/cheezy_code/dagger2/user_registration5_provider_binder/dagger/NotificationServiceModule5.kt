package cheezy_code.dagger2.user_registration5_provider_binder.dagger

import cheezy_code.dagger2.user_registration5_provider_binder.EmailService5
import cheezy_code.dagger2.user_registration5_provider_binder.NotificationService5
import dagger.Module
import dagger.Provides

@Module
class NotificationServiceModule5 {

    @Provides
    fun getMessageService(): NotificationService5 {
        return EmailService5()
    }
}