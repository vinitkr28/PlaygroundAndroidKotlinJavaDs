package cheezy_code.unit_testing.mock

class UserRepository {

    val users = listOf(
        User(id = 1, name = "name1", email = "email1@abc.com", password = "Abd@123"),
        User(id = 2, name = "name2", email = "email2@abc.com", password = "Abd@098"),
        User(id = 3, name = "name3", email = "email3@abc.com", password = "Abd@567"),
    )

    fun loginUser(email: String, password: String): LOGIN_STATUS {
        //Fetch User From DB

        val users= users.filter { user -> user.email == email }

        return if (users.size == 1) {
            if (users[0].password == password) LOGIN_STATUS.SUCCESS
            else LOGIN_STATUS.INVALID_PASSWORD
        } else LOGIN_STATUS.INVALID_USER
    }
}