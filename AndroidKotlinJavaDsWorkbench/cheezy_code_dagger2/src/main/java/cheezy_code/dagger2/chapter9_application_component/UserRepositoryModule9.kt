package cheezy_code.dagger2.chapter9_application_component

import cheezy_code.dagger2.chapter9_application_component.SQLRepository9
import cheezy_code.dagger2.chapter9_application_component.UserRepository9
import dagger.Module
import dagger.Provides


@Module
class UserRepositoryModule9 {

    /*@Provides
    fun getFirebaseRepository(): UserRepository5 {
        return FirebaseRepository5()
    }*/




    @Provides
    fun getSQLRepository(sqlRepository: SQLRepository9): UserRepository9 {
        return sqlRepository
    }


}