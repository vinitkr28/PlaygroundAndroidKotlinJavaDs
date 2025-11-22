package com.libleetcode.kotlin_string

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

class LC14LongestCommonPrefix {


    fun longestCommonPrefix1(strs: Array<String>): String {
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


    fun longestCommonPrefix2(strs: Array<String>): String {
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

    private fun getPrefixLastIndex(str1: String, str2: String): Int {
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


    fun longestCommonPrefix3(strs: Array<String>): String {
        val w = strs[0]
        w.forEachIndexed { i, c ->
            if (strs.any { it.length == i || it[i] != c }) return w.substring(0, i)
        }
        return w
    }
}

fun main() {
    val lC14LongestCommonPrefix = LC14LongestCommonPrefix()


    val strs1 = arrayOf("flower", "flow", "flight")
    val strs2 = arrayOf("dog","racecar","car")
    val strs3 = arrayOf("flower","flower","flower")

    println("*** longestCommonPrefix1 ***")
    println(lC14LongestCommonPrefix.longestCommonPrefix1(strs1).ifEmpty { "\"\"" })
    println(lC14LongestCommonPrefix.longestCommonPrefix1(strs2).ifEmpty { "\"\"" })
    println(lC14LongestCommonPrefix.longestCommonPrefix1(strs3).ifEmpty { "\"\"" })

    println("*** longestCommonPrefix2 ***")
    println(lC14LongestCommonPrefix.longestCommonPrefix2(strs1).ifEmpty { "\"\"" })
    println(lC14LongestCommonPrefix.longestCommonPrefix2(strs2).ifEmpty { "\"\"" })
    println(lC14LongestCommonPrefix.longestCommonPrefix2(strs3).ifEmpty { "\"\"" })

    println("*** longestCommonPrefix3 ***")
    println(lC14LongestCommonPrefix.longestCommonPrefix3(strs1).ifEmpty { "\"\"" })
    println(lC14LongestCommonPrefix.longestCommonPrefix3(strs2).ifEmpty { "\"\"" })
    println(lC14LongestCommonPrefix.longestCommonPrefix3(strs3).ifEmpty { "\"\"" })
}