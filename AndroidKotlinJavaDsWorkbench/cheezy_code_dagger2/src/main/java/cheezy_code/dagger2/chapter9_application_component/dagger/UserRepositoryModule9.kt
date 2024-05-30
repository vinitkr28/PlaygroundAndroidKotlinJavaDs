package cheezy_code.dagger2.chapter9_application_component.dagger

import cheezy_code.dagger2.chapter10_component_dependencies.SQLRepository9
import cheezy_code.dagger2.chapter10_component_dependencies.UserRepository9
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