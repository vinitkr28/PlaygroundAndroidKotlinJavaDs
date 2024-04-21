package cheezy_code.unit_testing.utils

import java.lang.StringBuilder

class Utils {

    fun validatePassword1(input: String) : Boolean {
        if (input.isEmpty()) return false

        if (input.length < 6) return false

        if (input.length > 15) return false

        return true
    }

    fun validatePassword2(input: String) = when {
        input.isBlank() -> {
            "Password is required field"
        }
        input.length < 6 -> {
            "Length of the password should be greater tna 6"
        }
        input.length > 15 -> {
            "Lenght od the password should be less than 15"
        }
        else -> {
            "Valid"
        }
    }

    fun reverseString1(input: String): String {

        val sb = StringBuilder()
        for (i in input.length-1 downTo 0) {
            sb.append(i)
        }

        return sb.toString()
    }

    fun reverseString2(input: String): String {
        val chars = input.toCharArray()
        var i = 0
        var j = chars.size - 1

        while (i < j) {
            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--
        }

        return chars.joinToString("")
    }

    fun reverseString3(input: String?): String {
        if (input == null) throw IllegalArgumentException("Input String is Required")

        val chars = input.toCharArray()
        var i = 0
        var j = chars.size - 1

        while (i < j) {
            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--
        }

        return chars.joinToString("")
    }
}