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