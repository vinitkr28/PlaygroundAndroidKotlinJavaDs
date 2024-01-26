package com.libkotlinpractice.constructor


/*
* - If you have any modifier then constructor keyword is required otherwise
*  we can initiate constructor without constructor keyword.
* - Primary constructor doesn't contain body. But init block can be used.
* - You can't create property in secondary constructor.
* - For the secondary constructor we must need to mention primary constructor
*   for secondary constructor.
* - If there is no primary constructor then secondary constructor will not ask
*   to mention primary constructor.
* */


class Human(name: String){
    private var fName = "N.A."

    init {
        fName = name

        println("init block1:-> $fName")
    }

    constructor(fName: String, lName: String) : this(fName) {
        this.fName = fName
        println("I am from secondary constructor. $fName $lName")
    }

    constructor(fName: String, lName: String, commanName: String): this(commanName) {
        println("Second secondary constructor. $fName $lName $commanName")
    }

    init {
        println("init block2:-> $fName")
    }

    fun think() {
        println("Kotlin is Awesome, $fName")
    }

}

class AsianHuman {
    lateinit var firstName: String
    constructor(fName: String, lName: String, ethnicity: String) {
        firstName = fName

        println("secondary constructor of AsianHuman. $firstName $lName -> $ethnicity")
    }

    fun printName() {
        println("AsianHuman::printName: $firstName")
    }
}


fun main() {
    var human = Human("Ram")
    println("Human object created.")
    human.think()
    println("************")

    val ManjeshKhannaHuman = Human("Manjesh", "Khanna")
    println("ManjeshKhannaHuman object created.")
    ManjeshKhannaHuman.think()
    println("************")

    val ShyamJeeHuman = Human("Shman", "Jee", "Gopalganj Wale")
    println("ShyamJeeHuman object created.")
    ShyamJeeHuman.think()
    println("************")

    val asianHuman = AsianHuman("Elvis", "Zing", "China")
    asianHuman.printName()
    println("************")
}