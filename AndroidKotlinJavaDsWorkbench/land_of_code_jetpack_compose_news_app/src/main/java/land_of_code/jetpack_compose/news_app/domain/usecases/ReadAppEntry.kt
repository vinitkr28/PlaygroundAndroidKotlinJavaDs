package land_of_code.jetpack_compose.news_app.domain.usecases

import kotlinx.coroutines.flow.Flow
import land_of_code.jetpack_compose.news_app.domain.manager.LocalUserManager

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    /*suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }*/

    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}