package com.libkotlinpractice.kotlin_collections

import kotlin.math.min


object Main {
    fun largestPowerof2(n: Long): Pair {
        var ans: Long = 0
        for (i in 30 downTo 0) {
            if (((1L shl i.toInt()) and n) != 0L) {
                ans = i.toLong()
                break
            }
        }
        // we do not want the character less than "a" ( which
        // is made up of 2^25 's "z" )
        ans = min(25.0, ans.toDouble()).toLong()
        return Pair(ans, 1L shl ans.toInt())
    }

    fun constructString(n: Long): String {
        var n = n
        val str = "abcdefghijklmnopqrstuvwxyz"
        val ans = StringBuilder()
        while (n != 0L) {
            val a = largestPowerof2(n)
            val pw = a.first
            val value = a.second
            ans.append(str[pw.toInt()])
            n -= value
        }
        return ans.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {

        var d:Boolean
        val n: Long = 11
        val result = constructString(n)
        println(result)
    }

    // Added a static inner class for pair
    class Pair(var first: Long, var second: Long)
}
