# [Dagger 2 - Dependency Injection in Android](https://youtube.com/playlist?list=PLRKyZvuMYSIPwjYw1bt_7u7nEwe6vATQd&si=ecRnQeOJc6H9smA0)

## Cheezy Code



### 1. [What is Dependency Injection? Tutorial - CheezyCode (Hindi) #1](https://youtu.be/DtzQkBp2M5M?si=9uQBgA6BP2B-5sGv)

    class Car() {
    private val engine: Engine = Engine()
    
        fun driveCar() {
            engine.start()
        }
    }  


   1. Car class is not testable
   2. Code is not extensible
   3. Single Responsibility
   4. Lifetime Of Objects (Reusability)
    
      * code cleanup


### 2. [Dagger 2 & Manual Dependency Injection Tutorial - CheezyCode (Hindi) #2](https://youtu.be/cg0yCHW2Keg?si=mtleHrSBxm_0cJf1)

   1. Dagger is a fully static, compile-time dependency injection framework.
   2. Compile time checking is performed if Dagger can create the required objects.
   3. Annotation Based

         * Dagger will behave as a system for us to create required objects.
         * Dagger will help us inject these objects.
         * Dagger will manage the lifetime of the objects.
         * Dagger will help us write manageable code.


##### Concept - 
1. [ ] Consumer (@Inject)
2. [ ] Producer (@Module, @Provides, @Binds)
3. [ ] Connector (@Component)


### 3. [Dagger 2 @Inject & @Component Tutorial - CheezyCode (Hindi) #3](https://youtu.be/vcr-wW50t8g?si=qjqvHVML0GgUo1FE)

   1. 
   2. 
   3. 

        * 


##### Concept -
1. [ ] 
2. [ ] 
3. [ ] 


### 4. [Dagger 2 Field Injection - @Inject Tutorial - CheezyCode (Hindi) #4](https://youtu.be/EDUK-IptF9w?si=PIndG31zXc_Hs3Si)

1.
2.
3.

      *


##### Concept -
1. [ ] 
2. [ ] 
3. [ ] 


### 5. [Dagger 2 @Module, @Provides, @Binds Annotation Tutorial - CheezyCode (Hindi) #5](https://youtu.be/2NT1Ef3F_Y0?si=3ZG04Rl6U-BEKIjo)

1.
2.
3.

      *


##### Concept -
1. [ ] 
2. [ ] 
3. [ ]



### 6. [Dagger 2 @Named Annotation & Qualifiers Tutorial - CheezyCode (Hindi) #6](https://youtu.be/z31Qfxyz5QM?si=xoCcT-k2CZxbHxik)

1. @Named Annotation
2. Qualifiers
3.

    *


##### Concept -
1. [ ] 
2. [ ] 
3. [ ] 


### 7. [Dagger 2 Component Factory Tutorial with @BindsInstance - CheezyCode (Hindi) #7](https://youtu.be/LvAiu9yVFT0?si=vCnnDieXQU9eS6vB)

1. Component Factory 
2. Pass Value To Modules At Runtime
3.

       val db = Room.databaseBuilder(
          applicationContext,
          AppDatabase::class.java, "database-name"
       ).build()


1. [ ] When we got the object at runtime
2. [ ] 
3. [ ] 


### 8. [Dagger 2 @Singleton Annotation & @Scopes - CheezyCode (Hindi) #8](https://youtu.be/pdS2JtfrXFs?si=cxXUjy1y83J0sIQq)

1. @Singleton Annotation
2. Scopes
3.

    


1. [ ] 
2. [ ] 
3. [ ] 



### 9. [Dagger 2 Application Component, @Singleton & @Scopes - CheezyCode (Hindi) #9](https://youtu.be/cTmsG2TTFVc?si=Pc_FF3H1MlIAFChF)

1. 
2. 
3.




1. [ ] 
2. [ ] 



### 10. [Dagger 2 Concepts Revisted, Component Dependencies - CheezyCode (Hindi) #10](https://youtu.be/szs80OgMsy8?si=EAh8As-Y7_EJrIvQ)

1.
2.
3.




1. [ ] 
2. [ ] 



  