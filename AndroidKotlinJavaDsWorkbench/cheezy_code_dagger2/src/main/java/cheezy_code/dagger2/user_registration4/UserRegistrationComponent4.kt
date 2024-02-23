package cheezy_code.dagger2.user_registration4

import cheezy_code.dagger2.user_registration4.views.UserRegistration4Activity
import dagger.Component

@Component
interface UserRegistrationComponent4 {

    /*
    //Example 1.
    fun getUserRegistrationService(): UserRegistrationService4

    fun getEmailService(): EmailService4
*/

    fun inject(userRegistration4Activity: UserRegistration4Activity)
}