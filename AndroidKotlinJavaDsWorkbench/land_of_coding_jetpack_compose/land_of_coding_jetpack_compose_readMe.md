# [Jetpack compose](https://www.youtube.com/playlist?list=PLzZEuVaFb9Ezi6LVAuEgzENCj8-032m_o)

## [Land of coding](https://www.youtube.com/@Landofcoding)

### 1/19. [What is Jetpack Compose? Why Compose? Compose Vs. Xml](https://youtu.be/k02U6T1qn_Y?si=qcID3cjO5Ok89c5S)
* Less Code
* Reusability
* Can use in web 
* UI for Desktop app
* Performance is higher compare with XML because it uses reactive programming


### 2/19. [Create your first jetpack compose application - jetpack compose basics](https://youtu.be/iEsa0M1-l6A?si=rKoSLqf_OKZ35E-K)


### 3/19. [Jetpack compose layouts](https://youtu.be/asxCEOl27Io?si=SODNTsZzXsSol7Yz)


### 4/19. [Jetpack Compose Modifier](https://youtu.be/vM0XhUOhnVI?si=K5EDJzXCFfWwKXeF)


### 5/19. [Jetpack Compose State/Stateful/Stateless/Save the ui state](https://youtu.be/zTTRV-_Ubkg?si=dXfDh7BQYIV7Xpa_)


### 5/19. [Text in Jetpack Compose From Beginner to Pro](https://youtu.be/mfNCRRY-uho?si=Z8sssB_69Jc2daB3)


### 6/19. [Text in Jetpack Compose From Beginner to Pro](https://youtu.be/mfNCRRY-uho?si=bUCRSRmJTMnR_6t9)

* `SecondActivity.kt`

### 7/19. [Create a post card in Android jetpack compose](https://youtu.be/KZGIouqkInY?si=d5o-fgmXu-AtdFKr)

* `PostCardActivity`
* `MyCustomCard.kt`

### 8/19. [Buttons in Jetpack Compose](https://youtu.be/Xx3s7YReM1M?si=rpBltzDq8JditwLB)

### 9/19. [Text Field in Jetpack Compose](https://youtu.be/4ksqf9B1lC4?si=lBO4To2gU_9wbrLB)


### 9/19. [Jetpack compose UI Challenge - building a modern login screen with Jetpack Compose](https://youtu.be/TCBAWdwupjU?si=j7ChB4JmhcutWLP5)


* Github
  * https://github.com/lofcoding/ComposeLoginScreenInit
* Figma
  * https://www.figma.com/design/De06Vj85aKVpYVh54HRhEP/Login-Screen---House-Rental-Solution-(Community)
    * LoggedIn with v4victor4u@gmail.com


### 10/19. [Jetpack compose UI Challenge - building a modern login screen with Jetpack Compose](https://youtu.be/TCBAWdwupjU?si=WYFbdPbqofMeY1l8)

* Github
  * Branch: screen-design
    * https://github.com/lofcoding/ComposeLoginScreen/tree/screen-design
    * https://github.com/lofcoding/ComposeLoginScreen/tree/support-screen-sizes/


### 11/19. [The Ultimate guide to supporting all screen sizes in Jetpack Compose using Material 3 design](https://youtu.be/Dj_X-RKL-c0?si=JVQVRiFbFOm3KonW)

* package: loggin_screen_all_screen_size
* implementation("androidx.compose.material3:material3-window-size-class:1.3.0")
  
  [![Window size classes](https://developer.android.com/static/develop/ui/compose/images/layouts/adaptive/window-size-classes/window_size_classes_width.png)](https://developer.android.com/develop/ui/compose/layouts/adaptive/window-size-classes)

### 12/19. [Jetpack compose Previews](https://youtu.be/EceFM3Ocv4Y?si=e68Gn3o6PogeFa77)
* Skipped this


### 13/19. [Full guide to Jetpack compose animations in Android](https://youtu.be/wLmVyXl4Now?si=CMkovKCKgzk4Yd0Q)
* Animations in Compose
  * Android Developer
    * https://developer.android.com/develop/ui/compose/animation/introduction


### 14/19. [Layout your screens using the Scaffold component - Compose](https://youtu.be/7SldQzpkO1o?si=YUdKwdAk_Gn4hC2E)

* `ScaffoldActivity`


### 15/19. [Full guide to Jetpack Compose Side Effects](https://youtu.be/mGpax3Y5B7E?si=Mx_TCIPgb-CPH5HY)

1. Launched Effect
2. remember Coroutine Scope
3. Disposable Effect
4. derivedStateOf
5. produce state
6. Side Effect
   * When you want to change non compose state inside a composable function and the way you want to change that state is not supported by digit composed apis
7. remember updated state
   * When we want to make a long run in time side effect always up to date
8. snapshot flow
   * convert from a state to kotlin flow


### 16/19. [Scrollable lists in Jetpack Compose](https://youtu.be/9ybBOUavglQ?si=jE7k5oFeCSw1aAPh)


### 17/19. [Jetpack compose navigation - basics](https://youtu.be/aCXofs2Zejk?si=C1-wUVxgUOtcGkmt)

`implementation("androidx.navigation:navigation-compose:2.8.3")`

* Navigation Controller
* Navigation Host


### 18/19. [Jetpack compose navigation - Transitions](https://youtu.be/MhXa-5Arw3Q?si=SLALBBHryTy-kbnE)
* https://developer.android.com/develop/ui/compose/animation/introduction
* https://developer.android.com/develop/ui/compose/animation/composables-modifiers

### 19/19. [Jetpack compose navigation - arguments](https://youtu.be/bj6OjSjPM1I?si=9VjyJOdRKdTXDc1A)

```
plugins {
---
id("kotlin-parcelize")
}
```

`import kotlinx.parcelize.Parcelize`


Simple arguments
Optional arguments
backstack entry
shared view model
Custom NavType


https://whimsical.com/