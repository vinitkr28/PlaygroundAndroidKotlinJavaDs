package cheezy_code.unit_testing.utils

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedExample(val input: String, val expectedValue: Boolean) {

    @Test
    fun test() {
        val helper = Helper()
        val  result = helper.isPallindromeLogic2(input)
        assertEquals(expectedValue, result)
    }

    companion object{

        @JvmStatic
        @Parameterized.Parameters(name = "isPallindromeLogic2 - {index} : {0} is pallindrome - {1}")
        fun data():List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true),
            )
        }
    }
}