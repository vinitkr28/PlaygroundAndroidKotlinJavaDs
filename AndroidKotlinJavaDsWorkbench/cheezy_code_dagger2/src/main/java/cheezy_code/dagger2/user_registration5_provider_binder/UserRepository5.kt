package cheezy_code.dagger2.user_registration5_provider_binder

import javax.inject.Inject

interface UserRepository5 {
    fun saveUser(email: String, password: String)
}

class SQLRepository5 @Inject constructor(): UserRepository5{

    override fun saveUser(email: String, password: String){
        println("User saved in DB")
    }
}

class FirebaseRepository5 @Inject constructor(): UserRepository5{

    override fun saveUser(email: String, password: String){
        println("User saved in Firebase")
    }
}