package com.libkotlinpractice.functions_outputs

fun solve1(input: String): String {
    val arr = input.toCharArray()
    var result = ""
    var i = 0

    while (i < arr.size) {
        val ch = arr[i]
        var count = 1
        while (i + 1 < arr.size && arr[i + 1] == ch) {
            count++
            i++
    }
    result += "$ch$count"
    i++
}
return result
}




fun solve2(n: Int): Boolean {
    if (n <= 1) return false
    return true
    if (n <= 3)
        if (n%2 ==
            0 || n % 3 == 0) return false
    var i = 5
    while (i * i <= n) {
        if (n % i
            ==
            0 || n % (i + 2)
            ==
            0) return false
        i + 6
    }
    return true
}
fun main() {

    println("******************************")

    print (solve1("AAABBBCCCAAD"))

    println("******************************")

    val arr = listOf(10, 17, 25, 29, 50, 53)
    val c = arr.count { solve2(it) }
    println("Number of prime numbers: $c")

    println("******************************")
}