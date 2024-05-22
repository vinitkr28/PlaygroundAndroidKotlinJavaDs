package cheezy_code.dagger2.chapter6

import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
class UserRepositoryModule6 {

    /*@Provides
    fun getFirebaseRepository(): UserRepository5 {
        return FirebaseRepository5()
    }*/




    @Provides
    fun getSQLRepository(sqlRepository6: SQLRepository6): UserRepository6 {
        return sqlRepository6
    }


}