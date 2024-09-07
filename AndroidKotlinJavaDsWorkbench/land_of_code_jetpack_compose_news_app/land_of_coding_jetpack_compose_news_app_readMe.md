# [Jetpack Compose - MVVM - Clean Architecture News App](https://youtube.com/playlist?list=PLzZEuVaFb9Exi-pc8qtHBrrLg8bUn-TP6&si=__pidvefTIy-7w-0)

## [Land of coding](https://www.youtube.com/@Landofcoding)

*  https://github.com/mohammednawas8
*  https://github.com/lofcoding/NewsApp/tree/master
*  https://github.com/lofcoding/NewsApp.git
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

### 9/19. []()

### 10/19. []()

### 11/19. []()

### 12/19. []()

### 13/19. []()

### 14/19. []()
### 15/19. []()
### 16/19. []()
### 17/19. []()
### 18/19. []()
### 19/19. []()

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

| Library Name | Version | Package                        | Links | Documents |
|--------------|---------|--------------------------------|-------|-----------|
| Kotlin       | 1.9.21  | org.jetbrains.kotlin.android   | -     | -         |
| Dagger/Hilt  | 2.50    | com.google.dagger.hilt.android | -     | -         |
| -            | -       | -                              | -     | -         | 




```

```

```
********** # Some Rough Work # **********
```

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
