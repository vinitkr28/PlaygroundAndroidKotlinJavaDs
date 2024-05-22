package cheezy_code.dagger2.chapter5

import dagger.Module
import dagger.Provides

@Module
class NotificationServiceModule5 {

    @Provides
    fun getMessageService(): NotificationService5 {
        return MessageService5()
    }
}