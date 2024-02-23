package cheezy_code.dagger2.user_registration7_component_factory

import javax.inject.Inject

interface UserRepository7 {
    fun saveUser(email: String, password: String)
}

class SQLRepository7 @Inject constructor(): UserRepository7{

    override fun saveUser(email: String, password: String){
        println("User saved in DB")
    }
}

class FirebaseRepository7 @Inject constructor(): UserRepository7{

    override fun saveUser(email: String, password: String){
        println("User saved in Firebase")
    }
}