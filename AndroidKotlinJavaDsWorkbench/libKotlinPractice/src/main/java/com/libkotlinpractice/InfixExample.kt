package com.libkotlinpractice

//https://www.geeksforgeeks.org/kotlin-infix-function-notation/
//infix function notation
/*
* It must be member function or extension function
* It must accepts a single parameter
* The parameter must not accept variable number of arguments and must have no default value
* It must be marked with infix keyword
* */

class InfixExample {
    infix fun squareArea(n : Int) : Int = n * n
}


class check{
    // user defined infix member function
    infix fun dataType(x: Any):Any{
        var i = when(x){
            is String -> "String"
            is Int -> "Integer"
            is Double -> "Double"
            else -> "invalid"
        }
        return i
    }
}

fun main() {
    val infixExample = InfixExample()
    val squareValue = infixExample squareArea 5
    println("squareValue: $squareValue")




    var chk = check()
    // call using infix notation
    var result = chk dataType 3.3
    println(result)


}


/*
* Precedence of infix function with operators-
Precedence matters at the time of execution of an instruction. Infix function calls have lower precedence than the arithmetic operators, type casts, and the rangeTo operator.
The following expressions are equivalent:


2 shr 1 + 2 and 2 shr (1 + 2)
1 until n * 2 and 0 until (n * 2)
xs union ys as Set<*> and xs union (ys as Set<*>)
On the other hand, infix function call have higher precedence than the boolean operators && and ||, is- and in-checks, and some other operators.
The following expressions are equivalent as well:


a xor b || c and a xor (b || c)
a in b xor c and a in (b xor c)
*
* */