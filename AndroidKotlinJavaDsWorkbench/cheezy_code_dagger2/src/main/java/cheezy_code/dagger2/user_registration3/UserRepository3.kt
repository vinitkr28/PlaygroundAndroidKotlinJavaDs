package cheezy_code.dagger2.user_registration3

import javax.inject.Inject

class UserRepository3 @Inject constructor(){

    fun saveUser(email: String, password: String){
        println("User saved in DB")
    }
}