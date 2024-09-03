### [mastering-automated-testing-of-industry-level-android-apps](https://elopage.com/payer/s/philipplackner/courses/mastering-automated-testing-of-industry-level-android-apps-1?course_session_id=6429488&lesson_id=3021426)


-- Added Junit5 Dependencies 









### [Top 3 Hacks to Remove LazyColumn Lag in Jetpack Compose - Android Studio Tutorial](https://youtu.be/s8h7GJTZa4E?si=C5CGEcmGZA22kRiw)

```
LazyColumn(
     - - -       
    ) {
        items(
            items = images,
            key = { eachImages ->
                eachImages.id
            }
        ) { 
        - - -
        }
    }
        
        
//@Stable
@Immutable
data class MyImage(
    val id: String = UUID.randomUUID().toString(),
    val resId: Int,
    val title: String,
    val tags: List<String>
)

```