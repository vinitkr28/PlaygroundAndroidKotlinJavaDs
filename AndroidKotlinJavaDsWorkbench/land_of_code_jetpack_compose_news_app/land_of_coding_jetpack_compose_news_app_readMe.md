# [Jetpack Compose - MVVM - Clean Architecture News App](https://youtube.com/playlist?list=PLzZEuVaFb9Exi-pc8qtHBrrLg8bUn-TP6&si=__pidvefTIy-7w-0)

## [Land of coding](https://www.youtube.com/@Landofcoding)

https://github.com/lofcoding/NewsApp/tree/master

### 1/19. [Introduction - Jetpack Compose Clean Architecture News App - part 1](https://youtu.be/9AekfR-EI-U?si=O-SQaCN_J9zDkeS3)



### 2/19. [Splash Screen - Jetpack Compose Clean Architecture News App - part 2](https://youtu.be/5cEyV9GwlnA?si=qBJ9gtXAgrRt7JSs)



### 3/19. [Onboarding Page - Jetpack Compose Clean Architecture News App - part 3](https://youtu.be/ZwmFEFRLrOA?si=Sd0UwpDNrgVTtAlS)



### 4/19. [Onboarding Screen - Jetpack Compose Clean Architecture News App - part 4](https://youtu.be/rMhOCuc8XIE?si=NSXBwfqI2vx11hwo)



### 5/19. [Preferences datastore - Jetpack Compose Clean Architecture News App - part 5](https://youtu.be/rpBYw5JMZHk?si=qT_iRaxcTXUhSFmy)


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



[![MVVM and clean architecture](https://miro.medium.com/v2/resize:fit:4800/format:webp/1*szHJJztWnmjO5U3boRZWiA.png)](https://medium.com/@abhineshchandra1234/movies-app-7d5362c52ae5)


### 6/19. [Dagger Hilt - Jetpack Compose Clean Architecture News App - part 6](https://youtu.be/PDABkIkDE04?si=0b4Y_gKD9Gf3vYW5)

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
   3. use this application class in`AndroidManifest.xml`
   4. create interface`AppModule`
   5. annotate Activity with`@AndroidEntryPoint`

### 7/19. [Onboarding ViewModel - Jetpack Compose Clean Architecture News App - part 7](https://youtu.be/guklBqKx2U8?si=KH1lO3MCmSy73YjC)

```
@HiltViewModel
class OnBoardingViewModel @Inject constructor(){

}
```
### 8/19. []()
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



<dl>
  <dt>First Term</dt>
  <dd>This is the definition of the first term.</dd>
  <dt>Second Term</dt>
  <dd>This is one definition of the second term. </dd>
  <dd>This is another definition of the second term.</dd>
</dl>


| Syntax      | Description |
| ----------- | ----------- |
| Header      | Title       |
| Paragraph   | Text        |




| Syntax | Description |
| --- | ----------- |
| Header | Title |
| Paragraph | Text |


```
{
  "firstName": "John",
  "lastName": "Smith",
  "age": 25
}
```








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
