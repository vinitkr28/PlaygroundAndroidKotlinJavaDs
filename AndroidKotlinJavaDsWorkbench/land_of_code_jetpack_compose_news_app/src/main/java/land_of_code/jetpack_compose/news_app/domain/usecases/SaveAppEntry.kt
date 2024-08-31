package land_of_code.jetpack_compose.news_app.domain.usecases

import land_of_code.jetpack_compose.news_app.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}