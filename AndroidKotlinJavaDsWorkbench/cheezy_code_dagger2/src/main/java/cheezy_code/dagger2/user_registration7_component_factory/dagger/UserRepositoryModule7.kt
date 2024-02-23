package cheezy_code.dagger2.user_registration7_component_factory.dagger

import cheezy_code.dagger2.user_registration7_component_factory.FirebaseRepository7
import cheezy_code.dagger2.user_registration7_component_factory.SQLRepository7
import cheezy_code.dagger2.user_registration7_component_factory.UserRepository7
import dagger.Binds
import dagger.Module
import dagger.Provides



@Module
abstract class UserRepositoryModule7 {

    @Binds
    abstract fun getSqlRepository(sqlRepository: SQLRepository7): UserRepository7
}