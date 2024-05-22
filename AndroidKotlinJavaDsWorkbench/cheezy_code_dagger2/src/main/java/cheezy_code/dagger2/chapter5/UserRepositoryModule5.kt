package cheezy_code.dagger2.chapter5

import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
class UserRepositoryModule5 {

    /*@Provides
    fun getFirebaseRepository(): UserRepository5 {
        return FirebaseRepository5()
    }*/




    @Provides
    fun getSQLRepository(sqlRepository5: SQLRepository5): UserRepository5 {
        return sqlRepository5
    }


}