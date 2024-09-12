package land_of_code.jetpack_compose.news_app.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import land_of_code.jetpack_compose.news_app.data.local.NewsDao
import land_of_code.jetpack_compose.news_app.data.local.NewsDatabase
import land_of_code.jetpack_compose.news_app.data.local.NewsTypeConverter
import land_of_code.jetpack_compose.news_app.data.manager.LocalUserManagerImpl
import land_of_code.jetpack_compose.news_app.data.remote.NewsApi
import land_of_code.jetpack_compose.news_app.data.repository.NewsRepositoryImpl
import land_of_code.jetpack_compose.news_app.domain.manager.LocalUserManager
import land_of_code.jetpack_compose.news_app.domain.repository.NewsRepository
import land_of_code.jetpack_compose.news_app.domain.usecases.app_entry.AppEntryUseCases
import land_of_code.jetpack_compose.news_app.domain.usecases.app_entry.ReadAppEntry
import land_of_code.jetpack_compose.news_app.domain.usecases.app_entry.SaveAppEntry
import land_of_code.jetpack_compose.news_app.domain.usecases.news.DeleteArticle
import land_of_code.jetpack_compose.news_app.domain.usecases.news.GetNews
import land_of_code.jetpack_compose.news_app.domain.usecases.news.NewsUseCases
import land_of_code.jetpack_compose.news_app.domain.usecases.news.SearchNews
import land_of_code.jetpack_compose.news_app.domain.usecases.news.SelectArticle
import land_of_code.jetpack_compose.news_app.domain.usecases.news.SelectArticles
import land_of_code.jetpack_compose.news_app.domain.usecases.news.UpsertArticle
import land_of_code.jetpack_compose.news_app.util.Constants
import land_of_code.jetpack_compose.news_app.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsDao = newsDao, newsApi = newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository = newsRepository),
            searchNews = SearchNews(newsRepository = newsRepository),
            deleteArticle = DeleteArticle(newsRepository = newsRepository),
            selectArticles = SelectArticles(newsRepository = newsRepository),
            upsertArticle = UpsertArticle(newsRepository = newsRepository),
            selectArticle = SelectArticle(newsRepository = newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = Constants.NEWS_DB
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}