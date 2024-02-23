package cheezy_code.dagger2.user_registration4

import javax.inject.Inject

class UserRepository4 @Inject constructor(){

    fun saveUser(email: String, password: String){
        println("User saved in DB")
    }
}