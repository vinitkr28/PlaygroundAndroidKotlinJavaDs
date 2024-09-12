# [Jetpack Compose - MVVM - Clean Architecture News App](https://youtube.com/playlist?list=PLzZEuVaFb9Exi-pc8qtHBrrLg8bUn-TP6&si=__pidvefTIy-7w-0)

## [Land of coding](https://www.youtube.com/@Landofcoding)

* https://github.com/mohammednawas8
* https://github.com/lofcoding/NewsApp/tree/master
* https://github.com/lofcoding/NewsApp.git
* Discord - https://discord.com/invite/snFzU9dZqz

### 1/19. [Introduction - Jetpack Compose Clean Architecture News App - part 1](https://youtu.be/9AekfR-EI-U?si=O-SQaCN_J9zDkeS3)

1. [ ] Jetpack Compose
2. [ ] Clean Architecture
3. [ ] MVVM & MVI
4. [ ] Paging 3
5. [ ] Retrofit
6. [ ] Room
7. [ ] DataStorage Preferences
8. [ ] Dagger Hilt

* Use JDK17.
* dependent libraries added
* Fonts, drawables(.xml) & colors added.

### 2/19. [Splash Screen - Jetpack Compose Clean Architecture News App - part 2](https://youtu.be/5cEyV9GwlnA?si=qBJ9gtXAgrRt7JSs)

`splash.xml`
```
<resources>
    <style name="App.Starting.Theme" parent="Theme.SplashScreen" >
        <item name="windowSplashScreenBackground">@color/splash_screen_background</item>
        <item name="windowSplashScreenAnimatedIcon">@drawable/ic_splash</item>
        <item name="postSplashScreenTheme">@style/Theme.NewsApp</item>
    </style>
    
</resources>
```

* For splash.xml(night)
  * Right click on values -> Values Resource File ->
    * File name: splash
    * Available qualifiers: Night Mode
      * Night mode: Night

###### Use this resource in `AndroidManifest.xml`

`MainActivity.kt`
```
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        - - -
        installSplashScreen()
        - - -
    }
}
```

### 3/19. [Onboarding Page - Jetpack Compose Clean Architecture News App - part 3](https://youtu.be/ZwmFEFRLrOA?si=Sd0UwpDNrgVTtAlS)

* create presentation package
  * Screens
  * anythings related to the screen
  * rememberPagerState
    * HorizontalPager

### 4/19. [Onboarding Screen - Jetpack Compose Clean Architecture News App - part 4](https://youtu.be/rMhOCuc8XIE?si=NSXBwfqI2vx11hwo)

* `MainActivity`
  * `WindowCompat.setDecorFitsSystemWindows(window, false)`
* `themes.xml`
  * `<item name="android:windowTranslucentStatus">true</item>`
  * `<item name="android:windowTranslucentNavigation">true</item>`


### 5/19. [Preferences datastore - Jetpack Compose Clean Architecture News App - part 5](https://youtu.be/rpBYw5JMZHk?si=MYThA_DQTsYY5CeB)

[![MVVM and clean architecture](https://miro.medium.com/v2/resize:fit:4800/format:webp/1*szHJJztWnmjO5U3boRZWiA.png)](https://medium.com/@abhineshchandra1234/movies-app-7d5362c52ae5)

* Datastore preferences
* Clean Architecture
  * Maintainable
  * Scalable
  * Testable

1. [x] **Presentation** Layer
    * Views
    * ViewModel
    * DI
2. [x] **Data** Layer
    * DataSource {Remote/Local/Cache}
    * Api {Services}
    * Repository {impl}
    * Model {Remote}
    * Mapper {toDomain}
3. [x] **Domain** Layer
    * Repository {interface} 
    * Model {Domain} 
    * UseCase

###### Create Packages:
* data (Data Layer)
  * manager
    * `class LocalUserManagerImpl`
      * ```
        class LocalUserManagerImpl(private val context: Context) : LocalUserManager {
            override suspend fun saveAppEntry() {
              context.dataStore.edit { settings ->
                  settings[PreferencesKeys.APP_ENTRY] = true
              }
            }
        
            override fun readAppEntry() : Flow<Boolean> {
              return context.dataStore.data.map { preferences ->
                  preferences[PreferencesKeys.APP_ENTRY] ?: false
              }
            }
        
        }
        ```
        ```
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = "userSettings")
        ```
        ```
        private object PreferencesKeys {
          val APP_ENTRY = booleanPreferencesKey(name = "appEntry")
        }
        ```
* domain (Domain Layer)
  * manager
    * `interface LocalUserManager`
      * `suspend fun saveAppEntry()`
      * `fun readAppEntry() : Flow<Boolean>`
  
  * usecases
    * `class SaveAppEntry`
      * ```
        class SaveAppEntry(private val localUserManager : LocalUserManager) {
            suspend operator fun invoke() {
                localUserManager.saveAppEntry()
            }
        }
        ```
    * `class ReadAppEntry`
      * ```
        class ReadAppEntry(private val localUserManager : LocalUserManager) {
            operator fun invoke() : Flow<Boolean> {
                return localUserManager.readAppEntry()
            }
        }
        ```

### 6/19. [Dagger Hilt - Jetpack Compose Clean Architecture News App - part 6](https://youtu.be/PDABkIkDE04?si=0b4Y_gKD9Gf3vYW5)

`build.gradle.ks` Project level
````
plugins {
- - -
id("org.jetbrains.kotlin.android") version "1.9.21" apply false
id("com.google.dagger.hilt.android") version "2.50" apply false
}
````


`build.gradle.ks` App level
```
plugins {
    - - -
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}
     - - - 
     
dependencies {
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-compiler:2.50")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
}
```

1. [ ] **Dagger/Hilt**
   1. Create Application class
   2. add annotation @HiltAndroidApp
   ```
   @HiltAndroidApp
   class NewsApplication: Application() {
       override fun onCreate() {
           super.onCreate()
       }
   }
   ```
   3. use this application class in```AndroidManifest.xml```
   4. create interface```AppModule```
   5. annotate Activity with````@AndroidEntryPoint````
      * ````
        @AndroidEntryPoint
        class MainActivity : ComponentActivity() {
             - - -
        }
        ````
* domain -> usecases -> `AppEntryUseCases`
  * ```
    data class AppEntryUseCases(
         val readAppEntry: ReadAppEntry,
         val saveAppEntry: SaveAppEntry
     )
    ```
* `AppModule.kt`
  * ```
    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
    ```
    
### 7/19. [Onboarding ViewModel - Jetpack Compose Clean Architecture News App - part 7](https://youtu.be/guklBqKx2U8?si=usq6j8hVG_eRh-NF)

* presentation -> onboarding -> `OnBoardingViewModel`
    * ```
      @HiltViewModel
      class OnBoardingViewModel @Inject constructor(){
      
      }
      ```
* presentation -> onboarding -> `OnBoardEvent`
    * ```
      sealed class OnBoardingEvent {
      object SaveAppEntry : OnBoardingEvent()
      }
      ```

### 8/19. [Navgraph - Jetpack Compose Clean Architecture News App - part 8](https://youtu.be/FIX-BErk1lE?si=vNFHtpKGu9n1qdRj)

* presentation -> navgraph -> `Route.kt`
* presentation -> navgraph -> `NavGraph.kt`
* news_app -> `MainViewModel`

### 9/19. [System UI Controller - Jetpack Compose Clean Architecture News App - part 9](https://youtu.be/5s43YOl6w8w?si=t4vaMMy_b7HtMATG)

`MainActivity`
```
val isSystemInDarkMode = isSystemInDarkTheme()
val systemController = rememberSystemUiController()

SideEffect {
    systemController.setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = !isSystemInDarkMode
    )
}
```
`themes.xml`
```
<style name="Theme.NewsApp" parent="android:Theme.Material.Light.NoActionBar" >
    <!--  <item name="android:windowTranslucentStatus">true</item>  -->
    <!--  <item name="android:windowTranslucentNavigation">true</item>  -->
</style>
```

### 10/19. [Home Screen Get News - Jetpack Compose Clean Architecture News App - part 10](https://youtu.be/ww69apNPQJA?si=V6JCS-yb6uaejesN)
1. [x] https://newsapi.org/ [v4victor4u@gmail.com]
###### Create packages:
* create app_entry inside domain -> usecases and move `AppEntryYseCases`, `ReadAppEntry` and `SaveAppEntry`
* data
  * remote
    * dto(data transfer object) - package
    * `interface NewsApi`
    * `class NewsPagingSource`
  * repository
    * `class NewsRepositoryImpl`
* domain
  * model 
    * Article
    * Source
  * repository
    * `interface NewsRepository`
  * usecases
    * news
      * `class GetNews`

### 11/19. [Home Screen ViewModel - Jetpack Compose Clean Architecture News App - part 11](https://youtu.be/WYrC-bsUSRk?si=KtihybbR5Qt6NwC6)

* presentation
  * home
    * `HomeViewModel`
* domain
  * usecases
    * news
      * `NewsUseCases`
* di
  * `AppModule`
    * ```
      @Provides
      @Singleton
      fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
          .create(NewsApi::class.java)
      }
      ```
      ```
      @Provides
      @Singleton
      fun provideNewsRepository(
        newsApi: NewsApi
      ): NewsRepository = NewsRepositoryImpl(newsApi)
      ```
      ```
      @Provides
      @Singleton
      fun provideNewsUseCases(
        newsRepository: NewsRepository
      ) : NewsUseCases {
        return NewsUseCases(
          getNews = GetNews(newsRepository)
       )
      }
      ```
* presentation
  * common 
    * `ArticleCard.kt`
    * `ShimmerEffect.kt`
      

### 12/19. [Finish Home Screen - Jetpack Compose Clean Architecture News App - part 12](https://youtu.be/3Kq1xIfcqtM?si=zYteaRQrFxF3V68W)

* presentation
    * common
      * `ArticlesList.kt`
      * `EmptyScreen.kt`
      * `SearchBar.kt`
    * home
      * `HomeScreen.kt`
    * navgraph
      * `NavGraph.kt`
        * 

### 13/19. [Search Screen - Jetpack Compose Clean Architecture News App - part 13](https://youtu.be/nLctxH_fSbM?si=BHZJE1pF1nn5Za54)

* data
  * remote
    * `NewsApi`
      * ```
        @GET("everything")
        suspend fun searchNews(
            @Query("q") searchQuery: String,
            @Query("page") page: Int,
            @Query("sources") sources: String,
            @Query("apiKey") apiKey: String = API_KEY
        ): NewsResponse
        ```
    * `SearchNewsPagingSource.kt`
  * repository
    * `NewsRepositoryImpl.kt`
      * ```
        override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
            return Pager(
                config = PagingConfig(pageSize = 10),
                pagingSourceFactory = {
                    SearchNewsPagingSource(
                        searchQuery = searchQuery,
                        newsApi = newsApi,
                        sources = sources.joinToString(separator = ",")
                    )
                }
            ).flow
        }
        ```
* domain
  * repository
    * `NewsRepository`
      * ```
        fun searchNews(searchQuery: String, sources: List<String>) : Flow<PagingData<Article>>
        ```

* presentation
  * search
    * `SearchState.kt`
    * `SearchEvent.kt`
    * `SearchViewModel.kt`
    * `SearchScreen.kt`
  * navgraph
    * `NavGraph`
* domain
  * usecases
    * news
      * `SearchNews.kt`
      * `NewsUseCases`
* di
  * `AppModule`

### 14/19. [Details Screen - Jetpack Compose Clean Architecture News App - part 14](https://youtu.be/CC3ybpzgm2M?si=fyNGk6e1DmvGrJ_t)

* presentation
  * details
    * components
      * `DetailsTopBar.kt`
    * `DetailsScreen.kt`
    * `DetailsEvent.kt`
* `AndroidManifest.xml`
* 

### 15/19. [Room Database - Jetpack Compose Clean Architecture News App - part 15](https://youtu.be/mY4ejkfdPz0?si=edIIMVTCjRA1hSbI)

* **GitHub:**
  * lofcoding / NewsApp
    * _branch:_ [part11-RoomDatabase](https://github.com/lofcoding/NewsApp/tree/part11-RoomDatabase)
  * vinitkr28 / PlaygroundAndroidKotlinJavaDs
    * _branch:_ [LandOfCoding/JetpackComposeNewsApp/15-Room-Database-part-15](https://github.com/vinitkr28/PlaygroundAndroidKotlinJavaDs/tree/LandOfCoding/JetpackComposeNewsApp/15-Room-Database-part-15/AndroidKotlinJavaDsWorkbench/land_of_code_jetpack_compose_news_app)

* domain
  * model
    * `Article`
* data
  * local
    * `NewsDao.kt`
    * `NewsTypeConverter.kt`
    * `NewsDatabase.kt`
* di
  * `AppModule`
* `MainActivity`

### 16/19. [Bookmark Screen - Jetpack Compose Clean Architecture News App - part 16](https://youtu.be/kB-uQUxSnoc?si=m6hp8kV4d5Is5TlQ)

* **GitHub:**
  * lofcoding / NewsApp
    * _branch:_ [part12-Bookmark](https://github.com/lofcoding/NewsApp/tree/part12-Bookmark)
  * vinitkr28 / PlaygroundAndroidKotlinJavaDs
    * _branch:_ [LandOfCoding/JetpackComposeNewsApp/16-Bookmark-Screen-part-16](https://github.com/vinitkr28/PlaygroundAndroidKotlinJavaDs/tree/LandOfCoding/JetpackComposeNewsApp/16-Bookmark-Screen-part-16/AndroidKotlinJavaDsWorkbench/land_of_code_jetpack_compose_news_app)

* presentation
  * bookmark
    * `BookMarkViewModel.kt`
    * `BookmarkState.kt`
    * `BookmarkScreen.kt`
  * common
    * `ArticleList`
  * navgraph
    * `NavGraph`
* domain
  * usecases
    * news
      * `UpsertArticle.kt`
      * `DeleteArticle.kt`
      * `SelectArticles.kt`
      * `NewsUseCases`

### 17/19. [News Navigator - Jetpack Compose Clean Architecture News App - part 17](https://youtu.be/94biU8_HcT8?si=9-7NA0FwFNUPBL8E)

* **GitHub:**
  * lofcoding / NewsApp
    * _branch:_ [part13-CodeCleanup](https://github.com/lofcoding/NewsApp/tree/part13-CodeCleanup)
  * vinitkr28 / PlaygroundAndroidKotlinJavaDs
    * _branch:_ [LandOfCoding/JetpackComposeNewsApp/17-News-Navigator-part-17](https://github.com/vinitkr28/PlaygroundAndroidKotlinJavaDs/tree/LandOfCoding/JetpackComposeNewsApp/17-News-Navigator-part-17/AndroidKotlinJavaDsWorkbench/land_of_code_jetpack_compose_news_app)

* data
  * local
    * `NewsDao`
  * repository
    * `NewsRepositoryImpl`
* domain
  * model
    * `Article`
    * `Source`
  * repository
    * `NewsRepository`
  * usecases
    * news
      * `SelectArticle.kt`
      * `SelectArticles.kt`
      * `DeleteArticle.kt`
      * `UpsertArticle`
      * `NewsUseCases`
* presentation
  * bookmark
    * `BookmarkScreen`
    * `BookmarkViewModel`
  * details
    * `DetailsEvent`
    * `DetailsScreen`
    * `DetailViewModel.kt`
  * news_navigator
    * `NewsNavigator.kt`
    * components
      * `NewsBottomNavigation.kt`
  * navgraph
    * `NavGraph`
  * search
    * `SearchScreen`
  * home
    * `HomeScreen`
* di
  * `AppModule`
* `build.gradle.kts`

### 18/19. [News app refactoring code and fixing bugs - Live stream 🔴](https://www.youtube.com/live/XVvsetaur8w?si=s3VDooUUvqouFIaX)

### 19/19. []()



<br/><br/>

| Library Name  | Version | Package                                                                                                                                                                           | Links | Documents |
|---------------|---------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------|-----------|
| _Kotlin_      | 1.9.21  | org.jetbrains.kotlin.android                                                                                                                                                      | -     | -         |
| _Dagger/Hilt_ | 2.50    | com.google.dagger.hilt.android                                                                                                                                                    | -     | -         |
| _Room_        | 2.6.1   | * implementation("androidx.room:room-runtime:$room_version")<br/>* kapt("androidx.room:room-compiler:$room_version")<br/>* implementation("androidx.room:room-ktx:$room_version") | -     | -         |
| -             | -       |                                                                                                                                                                                   |       |           |
| -             | -       | -                                                                                                                                                                                 | -     | -         |
| -             | -       | -                                                                                                                                                                                 | -     | -         | 
| -             | -       | -                                                                                                                                                                                 | -     | -         |
| -             | -       | -                                                                                                                                                                                 | -     | -         | 
| -             | -       | -                                                                                                                                                                                 | -     | -         |
| -             | -       | -                                                                                                                                                                                 | -     | -         | 


&nbsp;

* ### **operator**
  * keyword that translated to an expression.
    * invoke operator
      * ```
        fun doSomething(arg: () -> Unit) {
          //arg()
          arg.invoke()
        }
        ```
        * The usecase should do one thing only
          * ```
              class FirstUseCase() {
                //fun execute() {} 
                operator fun invoke() {}
              }
            ```
            ```
              class SecondUseCase() {
                fun execute() {} 
              }
            ```
            ```
              val firstUsecase = FirstUseCase()
              val secondUsecase = FirstUseCase()
              fun main() {
                //firstUsecase.execute()
                //firstUsecase.invoke()//We can call in this way also.
                firstUsecase()
            
                secondUsecase.execute()
              }
            ```
          * ```
            interface BaseUseCase() {
              //fun execute() {} 
              operator fun invoke() {}
            }
            ```
            ```
            class MyFirstUseCase(): BaseUseCase {
              //fun execute() {}
              override operator fun invoke() {}
            }
            ```
            ```
            class MySecondUseCase(): BaseUseCase {
              //fun execute() {}
              override operator fun invoke() {}
            }
            ```
            ```
            val baseUseCase = MyFirstUseCase()
            fun main() {
              baseUseCase()
            }
            ```
```

```

* discord
  * discord.gg/snFzU9dZqz
* Instagram 
  * instagram.com/mohammednas88
* Github 
  * github.com/mohammednawas8
* LinkedIn 
  * linkedin.com/in/mohammad-nawas-37034b226

```
********** # Some Rough Work # **********
```



&nbsp;&nbsp;

\ \


` `  
` `

&nbsp;


Line one\
\
\
\
Line two

<br/><br/>


<dl>
  <dt>Library Name</dt>
  <dd>This is the definition of the first term.</dd>
  <dt>Second Term</dt>
  <dd>This is one definition of the second term. </dd>
  <dd>This is another definition of the second term.</dd>
</dl>













    Indent paragraphs to include them in the footnote.

    `{ my code }`

    Add as many paragraphs as you like.


First Term
: This is the definition of the first term.

Second Term
: This is one definition of the second term.
: This is another definition of the second term.



<dl>
  <dt>First Term</dt>
  <dd>This is the definition of the first term.</dd>
  <dt>Second Term</dt>
  <dd>This is one definition of the second term. </dd>
  <dd>This is another definition of the second term.</dd>
</dl>



~~The world is flat.~~ We now know that the world is round.


Gone camping! :tent: Be back soon.

That is so funny! :kissing_closed_eyes:

https://gist.github.com/rxaviers/7360908


I need to highlight these ==very important words==.


H~2~O


H<sub>2</sub>O

X^2^

X<sup>2</sup>

`http://www.example.com`
