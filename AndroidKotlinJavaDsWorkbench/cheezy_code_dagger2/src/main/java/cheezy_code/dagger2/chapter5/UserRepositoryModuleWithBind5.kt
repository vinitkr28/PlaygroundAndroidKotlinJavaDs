package cheezy_code.dagger2.chapter5

import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
abstract class UserRepositoryModuleWithBind5 {

    /*@Provides
    fun getFirebaseRepository(): UserRepository5 {
        return FirebaseRepository5()
    }*/




    /*@Provides
    fun getSQLRepository(sqlRepository5: SQLRepository5): UserRepository5 {
        return sqlRepository5
    }*/


    @Binds
    abstract fun getFirebaseRepository(sqlRepository5: SQLRepository5): UserRepository5
}