package land_of_code.jetpack_compose.news_app.util

import land_of_code.jetpack_compose.news_app.R
import land_of_code.jetpack_compose.news_app.presentation.news_navigator.components.BottomNavigationItem

object Constants {

    const val USER_SETTINGS = "userSettings"

    const val APP_ENTRY = "appEntry"

    const val API_KEY = "59c09252879c46eea3f3428f38169168"

    const val BASE_URL = "https://newsapi.org/v2/"

    const val NEWS_SOURCES = "top-headlines/sources"//"https://newsapi.org/v2/top-headlines/sources?apiKey=API_KEY"

    const val NEWS_DB = "news_db"

    val navigationBottomItems = listOf(
        BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
        BottomNavigationItem(icon = R.drawable.ic_search, text = "Search"),
        BottomNavigationItem(icon = R.drawable.ic_bookmark, text = "Bookmark"),
    )
}