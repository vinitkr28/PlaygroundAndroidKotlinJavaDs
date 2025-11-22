package com.libleetcode.kotlin_string

class Abc {


    /*
    https://leetcode.com/problems/longest-common-prefix/?envType=problem-list-v2&envId=string
    14. Longest Common Prefix

    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

    Example 1:

    Input: strs = ["flower","flow","flight"]
    Output: "fl"


    Example 2:

    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.


    Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters if it is non-empty.
    */

    fun longestCommonPrefix5(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        if (strs.size == 1) return strs[0]
        var finalValue = ""
        var indexOfSmallestText = strs[0].length
        for (text in strs) {
            indexOfSmallestText = Math.min(text.length, indexOfSmallestText)
        }
        for (i in 0 until indexOfSmallestText) {
            val currentChar = strs[0][i]
            var matchFound = true
            for (text in strs) {
                if (text[i] != currentChar) {
                    matchFound = false
                    break
                }
            }
            if (matchFound) {
                finalValue += currentChar
            } else {
                break
            }
        }
        return finalValue
    }


    fun longestCommonPrefix9(strs: Array<String>): String {
        val first = strs[0]
        if (strs.size == 1 || first.length == 0) return first
        var minLastIndex = first.length

        for (i in 1..strs.size-1) {
            val prefixLastIndex = getPrefixLastIndex(first, strs[i])
            if (prefixLastIndex == 0) {
                return ""
            } else {
                minLastIndex = minOf(minLastIndex, prefixLastIndex)
            }
        }

        return first.substring(0, minLastIndex)
    }

    fun getPrefixLastIndex(str1: String, str2: String): Int {
        val minLength = minOf(str1.length, str2.length)
        var count = 0
        for (i in 0..minLength-1) {
            if (str1[i] == str2[i]) {
                count++
            } else {
                return count
            }
        }
        return count
    }



    fun longestCommonPrefix4(strs: Array<String>): String {

        if (strs.isEmpty()) return ""

        if (strs.size == 1) return strs[0]

        var finalValue = ""

        var indexOfSmallestText: Int = strs[0].length

        for (text in strs) {
            indexOfSmallestText = Math.min(text.length, indexOfSmallestText)
        }

        var currentChar = strs[0][0]


        /* for (i in 1) {

         }*/

        /*for (i in 0 until indexOfSmallestText) {
            val currentChar = strs[0][i]
            var matchFound = true
            for (text in strs) {
                if (text[i] != currentChar) {
                    matchFound = false
                    break
                }
            }
            if (matchFound) {
                finalValue += currentChar
            } else {
                break
            }
        }*/

        return ""
    }

    /*fun longestCommonPrefix1(a: Array<String>) = buildString {
        a.minBy { it.length }?.forEachIndexed { i, c -> if (a.all { it[i] == c }) append(c) else return toString() }
    }*/

    fun longestCommonPrefix2(strs: Array<String>): String {
        val w = strs[0]
        w.forEachIndexed { i, c ->
            if (strs.any { it.length == i || it[i] != c }) return w.substring(0, i)
        }
        return w
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        var finalValue = ""
        var currentPointer = 0
        var currentPointerValue: Char

        if (strs.isEmpty() || strs[0].isEmpty()) return ""

        if (strs.size == 1) return strs[0]

        currentPointerValue = strs[0][0]


        var matchFound = false

        for (textAt in 1..strs.size - 1) {
            if (strs[textAt].length > currentPointer && strs[textAt][currentPointer] != currentPointerValue) {
                break;
            } else {
                finalValue += currentPointerValue
                currentPointer++
                if (strs[0].length > currentPointer) {
                    currentPointerValue = strs[0][currentPointer]
                }
            }
        }

        return finalValue;
    }


    fun romanToInt(s: String): Int {

        var currentPointer = 0
        var total = 0


        while (currentPointer < s.length) {

            when (s[currentPointer]) {
                'I' -> {
                    //I can be placed before V (5) and X (10) to make 4 and 9.
                    if ((currentPointer) < s.length - 1 && s[currentPointer + 1] == 'V') {

                        total += 4
                        currentPointer += 2


                    } else if ((currentPointer) < s.length - 1 && s[currentPointer + 1] == 'X') {

                        total += 9
                        currentPointer += 2

                    } else {

                        total += 1
                        currentPointer++

                    }
                }

                'V' -> {
                    currentPointer++
                    total += 5
                }

                'X' -> {
                    //X can be placed before L (50) and C (100) to make 40 and 90.
                    if ((currentPointer) < s.length - 1 && s[currentPointer + 1] == 'L') {

                        total += 40
                        currentPointer += 2


                    } else if ((currentPointer) < s.length - 1 && s[currentPointer + 1] == 'C') {

                        total += 90
                        currentPointer += 2

                    } else {

                        total += 10
                        currentPointer++

                    }
                }

                'L' -> {
                    currentPointer++
                    total += 50
                }

                'C' -> {
                    //C can be placed before D (500) and M (1000) to make 400 and 900.
                    if ((currentPointer) < s.length - 1 && s[currentPointer + 1] == 'D') {

                        total += 400
                        currentPointer += 2


                    } else if ((currentPointer) < s.length - 1 && s[currentPointer + 1] == 'M') {

                        total += 900
                        currentPointer += 2

                    } else {

                        total += 100
                        currentPointer++

                    }
                }

                'D' -> {
                    currentPointer++
                    total += 500
                }

                'M' -> {
                    currentPointer++
                    total += 1000
                }
            }

        }
        return total
    }
}

fun main() {
    val str = """
        
             |ssdsd
        dsds\n|\n
        sdsd> 
        dsdsd
        dsds
        
    """.trimMargin(">")

    str.length


//    println(Abc().romanToInt("III"))
    println(Abc().longestCommonPrefix2(arrayOf("flower", "flower", "flower", "flower")))


    for (i in 1 until 10) {
        println(i)
    }

    val num1 = 16..1

    for (n in num1.reversed()) {
        print("$n, ")
    }

    val num2 = 16 downTo 1
    print("num2: ")
    for (n in num2.reversed()) {
        print("$n, ")
    }


}