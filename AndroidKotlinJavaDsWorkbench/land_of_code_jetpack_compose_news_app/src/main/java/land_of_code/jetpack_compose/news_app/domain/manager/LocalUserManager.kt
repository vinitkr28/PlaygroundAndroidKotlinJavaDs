package land_of_code.jetpack_compose.news_app.domain.manager

import kotlinx.coroutines.flow.Flow


interface LocalUserManager {

    suspend fun saveAppEntry()

    fun readAppEntry():Flow<Boolean>
}