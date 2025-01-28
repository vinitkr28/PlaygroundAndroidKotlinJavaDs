package com.libkotlinpractice.kotlin_collections

class MyKotlinCollections {

    fun method1() {

    }
}

fun main() {

    //Transformation Functions:


    //1. map:
    val numbers = listOf(1, 2, 3, 4, 5)
    val squareNumbers = numbers.map { it * it }

    println("squareNumbers: $squareNumbers")


    //2. flatMap:
    val words = listOf("hello", "world")
    val characters = words.flatMap { it.toList() } // Convert each word to a list of characters
    println(characters) // Output: [h, e, l, l, o, w, o, r, l, d]


    //3. distinct:
    val numbersWithDuplicates = listOf(1, 2, 3, 1, 2, 4, 5, 3)
    val uniqueNumbers = numbersWithDuplicates.distinct() // Remove duplicates
    println(uniqueNumbers) // Output: [1, 2, 3, 4, 5]




    //Filtering Functions


    //1. filter:
    val numbersFilter = listOf(1, 2, 3, 4, 5, 6)
    val evenNumbers = numbersFilter.filter { it % 2 == 0 }


    //2. filterNot:
    val numbersFilterNot = listOf(1, 2, 3, 4, 5, 6)
    val oddNumbers = numbersFilterNot.filterNot { it % 2 == 0 }

    //3. partition:
    val numbersPartition = listOf(1, 2, 3, 4, 5, 6)
    val (even, odd) = numbersPartition.partition { it % 2 == 0 }




    //Element Retrieval Functions


    //1. find :
    val numbersFind = listOf(1, 2, 3, 4, 5)
    val foundNumber = numbersFind.find { it > 3 } // Retrieves the first number greater than 3
    println(foundNumber) // Output: 4


    //2. firstOrNull :
    val colors = listOf("Red", "Green", "Blue")
    val firstColor = colors.firstOrNull()
    println(firstColor) // Output: Red

    val emptyList = emptyList<String>()
    val firstColorInEmptyList = emptyList.firstOrNull()
    println(firstColorInEmptyList) // Output: null


//    3. singleOrNull :
    val names = listOf("Alice")
    val singleName = names.singleOrNull()
    println(singleName) // Output: Alice

    val multipleNames = listOf("Alice", "Bob", "Charlie")
    val singleNameInMultiple = multipleNames.singleOrNull() // Returns null as the list has more than one element
    println(singleNameInMultiple) // Output: null




    //Aggregation Functions:


    //1. fold:
}