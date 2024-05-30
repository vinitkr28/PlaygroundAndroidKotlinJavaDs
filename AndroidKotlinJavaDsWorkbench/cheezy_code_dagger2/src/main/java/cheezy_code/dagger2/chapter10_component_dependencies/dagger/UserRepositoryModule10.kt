package cheezy_code.dagger2.chapter10_component_dependencies.dagger

import cheezy_code.dagger2.chapter10_component_dependencies.SQLRepository10
import cheezy_code.dagger2.chapter10_component_dependencies.UserRepository10
import dagger.Module
import dagger.Provides


@Module
class UserRepositoryModule10 {

    /*@Provides
    fun getFirebaseRepository(): UserRepository5 {
        return FirebaseRepository5()
    }*/




    @Provides
    fun getSQLRepository(sqlRepository: SQLRepository10): UserRepository10 {
        return sqlRepository
    }


}