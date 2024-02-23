package cheezy_code.dagger2.user_registration6_qualifiers.dagger

import cheezy_code.dagger2.user_registration6_qualifiers.SQLRepository6
import cheezy_code.dagger2.user_registration6_qualifiers.UserRepository6
import dagger.Binds
import dagger.Module


@Module
abstract class UserRepositoryModule6 {

    @Binds
    abstract fun getSqlRepository(sqlRepository6: SQLRepository6): UserRepository6
}