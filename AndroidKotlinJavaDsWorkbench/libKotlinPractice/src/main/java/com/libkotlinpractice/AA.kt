package com.libkotlinpractice

import java.util.EnumSet

fun solution2(A: IntArray, K: Int): Boolean {

val d= ""
    d.length

    val array: IntArray = (1..K).toList().toIntArray()

    return A.any {it in array}


}

/*fun main() {
    solution(intArrayOf(1, 2, 3, 4), 2)

//    for (number in range()) {}
}*/


fun modifyList1(list: MutableList<Int>) {

list.add(5)
//list = mutableListOf(1, 2, 3)
}
fun main() {
    val a = mutableListOf(10, 20, 30)
    modifyList1(a)
    println(a.joinToString("", ""))
}


fun solution(A: IntArray, K: Int): Boolean {
    // Check if the array is empty
    if (A.isEmpty()) {
        return false
    }

    // Create a set to store the numbers encountered
    val encounteredNumbers = mutableSetOf<Int>()

    // Iterate through the array
    for (number in A) {
        // Check if the number is within the range 1 to K
        if (number in 1..K) {
            // Add the number to the set
            encounteredNumbers.add(number)
        } else {
            // If the number is outside the range, return false
            return false
        }
    }

    // Check if the set contains all numbers from 1 to K

    val array = (1..K).toList()
    return encounteredNumbers.size == K && encounteredNumbers.containsAll(array)
}