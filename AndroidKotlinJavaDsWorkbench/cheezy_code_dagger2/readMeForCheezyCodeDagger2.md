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
   
