package cheezy_code.dagger2.chapter7

import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
class UserRepositoryModule7 {

    /*@Provides
    fun getFirebaseRepository(): UserRepository5 {
        return FirebaseRepository5()
    }*/




    @Provides
    fun getSQLRepository(sqlRepository: SQLRepository7): UserRepository7 {
        return sqlRepository
    }


}