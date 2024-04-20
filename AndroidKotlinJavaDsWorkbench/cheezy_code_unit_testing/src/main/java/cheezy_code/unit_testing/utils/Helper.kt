package cheezy_code.unit_testing.utils

class Helper {

    fun isPallindromeLogic1(inpit: String): Boolean {
        val reverse = inpit.reversed()

        return inpit == reverse
    }

    fun isPallindromeLogic2(inpit: String): Boolean {
        var i = 0
        var j = inpit.length - 1
        var result = true

        while (i < j) {
            if (inpit[i] != inpit[j]) {
                result = false
                break
            }
            i++;
            j--;
        }
        return result
    }

}