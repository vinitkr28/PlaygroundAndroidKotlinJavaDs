package cheezy_code.dagger2.user_registration5_provider_binder.dagger

import cheezy_code.dagger2.user_registration5_provider_binder.SQLRepository5
import cheezy_code.dagger2.user_registration5_provider_binder.UserRepository5
import dagger.Binds
import dagger.Module

/*

@Module
class UserRepositoryModule {

    */
/*@Provides
    fun getFirebaseRepository(): UserRepository5 {
        return FirebaseRepository5()
    }*//*


    @Provides
    fun getSqlRepository(sqlRepository5: SQLRepository5): UserRepository5 {
        return sqlRepository5
    }

    @Binds
    abstract fun getSqlRepository(sqlRepository5: SQLRepository5): UserRepository5
}

*/







@Module
abstract class UserRepositoryModule5 {

    @Binds
    abstract fun getSqlRepository(sqlRepository5: SQLRepository5): UserRepository5
}