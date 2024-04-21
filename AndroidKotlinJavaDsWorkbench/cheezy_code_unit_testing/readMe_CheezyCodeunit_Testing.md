Android Unit Testing Playlist - JUnit, Espresso, Mockito with Kotlin
Cheezy Code
https://www.youtube.com/playlist?list=PLRKyZvuMYSIMKOSCLYPVAtqLGqQa0JtU5
https://youtube.com/playlist?list=PLRKyZvuMYSIMKOSCLYPVAtqLGqQa0JtU5&si=ulzsV8eRlAhFWty2



   - JUNIT
     - JVM TESTS
   - MOCKITO
     - Mock Object or Fake Objects
   - ESPRESO
     - UI Interactions




1. Android Unit Testing Tutorial | Introduction - CheezyCode - Hindi
   https://youtu.be/9yre-M1XwVw?si=E_aiVOPmrjNByRpI
   cheezy_code/unit_testing/1-Introduction


   - Unit Test
     - JVM Test (Local Unit Test)
     - On Device Test (Instrumentation Test)
       - UI Tests (Interaction with Views)
       - Non UI Tests (Context, Asset Manager, etc...)




 
2. Android JUnit Introduction Tutorial | Parameterized Tests Kotlin - CheezyCode - Hindi
   https://youtu.be/LdZdAofm7hk?si=ezam5d0CjdC6Og9z
   cheezy_code/unit_testing/2-Parameterized-Tests-Kotlin

    
    @Test
    fun testPallindrome(){
        //Arrange
        //Act
        //Assert
    }

    - @RunWith(value = Parameterized::class)
    - @JvmStatic
    - @Parameterized.Parameters(name = "isPallindromeLogic2 - {index} : {0} is pallindrome - {1}")


3. Android Instrumentation Tests Tutorial | Assert Exceptions Kotlin - CheezyCode - Hindi
   https://youtu.be/crd4IPEJtkI?si=ftdiiNjJO0yX5Wll
   cheezy_code/unit_testing/3-Assert-Exceptions-Kotlin


    @Test
    fun testPallindrome(){
        //Arrange
        //Act
        //Assert
    }

    - @RunWith(value = Parameterized::class)
    - @JvmStatic
    - @Parameterized.Parameters(name = "isPallindromeLogic2 - {index} : {0} is pallindrome - {1}")



4. Android Local Unit Test - Practice Problems | Kotlin - CheezyCode - Part 1
    https://youtu.be/Cq7YHb5tKmQ?si=cRqtz2Noc-ew-Veh
    cheezy_code/unit_testing/4-Android-Local-Unit-Test-Practice-Problems-Part1

    * Problem Statement: Validate Password
        - Should not be empty
        - Length should between or equal to 6 & 15
        - Otherwise, return Valid Password
    
    * Problem Statement: String Reversal
        - "ABC" -> "CAB"
        - 
5. Android Local Unit Test - Solution Video | Kotlin - CheezyCode - Part 2
   https://youtu.be/r9cC5yDzNZ4?si=PBkr1mgYParcIX92
   cheezy_code/unit_testing/4-Android-Local-Unit-Test-Practice-Solution-Part2