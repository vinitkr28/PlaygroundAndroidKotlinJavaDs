package com.libkotlinpractice.kotlin_collections

fun solution(N: Int): String {
    if (N <= 1) {
        return "a"
    }

    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    val sb = StringBuilder()
    var count = N
    var currentLetterIndex = 0

    while (count > 0) {
        val remainingLetters = count % 26
        val lettersToAdd = if (remainingLetters == 0) 26 else remainingLetters
        val letter = alphabet[currentLetterIndex]

        for (i in 0 until lettersToAdd) {
            sb.append(letter)
        }

        count -= lettersToAdd
        currentLetterIndex = (currentLetterIndex + 1) % 26
    }

    return sb.toString()
}


fun solution2(N: Int): String {
    if (N <= 1) {
        return "a"
    }

    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    val sb = StringBuilder()
    var count = N
    var currentLetterIndex = 0

    while (count > 0) {
        val remainingLetters = count % 26
        val lettersToAdd = if (remainingLetters == 0) 26 else remainingLetters
        val letter = alphabet[currentLetterIndex]

        for (i in 0 until lettersToAdd) {
            sb.append(letter)
        }

        count -= lettersToAdd
        currentLetterIndex = (currentLetterIndex + 1) % 26
    }

    return sb.toString()
}