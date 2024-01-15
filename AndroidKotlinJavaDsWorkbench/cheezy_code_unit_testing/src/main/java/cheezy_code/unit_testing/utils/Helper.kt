package cheezy_code.unit_testing.utils

class Helper {

    fun isPalindrome(text: String): Boolean {
        var result = true
        var i = 0
        var j = text.length - 1

        while (i < j) {
            if (text[i] != text[j]) {
                result = false
                break
            }
            i++
            j--
        }

        return result
    }
}