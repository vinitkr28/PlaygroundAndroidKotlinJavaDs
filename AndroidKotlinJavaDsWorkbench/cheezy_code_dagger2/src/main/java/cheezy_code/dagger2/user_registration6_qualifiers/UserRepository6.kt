package cheezy_code.dagger2.user_registration6_qualifiers

import javax.inject.Inject

interface UserRepository6 {
    fun saveUser(email: String, password: String)
}

class SQLRepository6 @Inject constructor(): UserRepository6{

    override fun saveUser(email: String, password: String){
        println("User saved in DB")
    }
}

class FirebaseRepository6 @Inject constructor(): UserRepository6{

    override fun saveUser(email: String, password: String){
        println("User saved in Firebase")
    }
}