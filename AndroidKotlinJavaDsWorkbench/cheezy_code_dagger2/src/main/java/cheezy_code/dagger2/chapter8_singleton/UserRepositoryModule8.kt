package cheezy_code.dagger2.chapter8_singleton

import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
class UserRepositoryModule8 {

    /*@Provides
    fun getFirebaseRepository(): UserRepository5 {
        return FirebaseRepository5()
    }*/




    @Provides
    fun getSQLRepository(sqlRepository: SQLRepository8): UserRepository8 {
        return sqlRepository
    }


}