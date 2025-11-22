package com.libleetcode.kotlin_string

class KotlonStringLeetCodeDsa {


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