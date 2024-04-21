package cheezy_code.unit_testing.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.IllegalArgumentException

class StringTest {

    @Test
    fun testStringReversal2_EmptyString_expectedEmptyString() {
        val sut = Utils()
        val result = sut.reverseString2("")
        assertEquals("", result)
    }

    @Test
    fun testStringReversal2_SingleChar_expectedSingleChar() {
        val sut = Utils()
        val result = sut.reverseString2("a")
        assertEquals("a", result)
    }

    @Test
    fun testStringReversal2_ValidInput_expectedSameString() {
        val sut = Utils()
        val result = sut.reverseString2("CheezyCode")
        assertEquals("edoCyzeehC", result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReversal2_NullValue_expectedException() {
        val sut = Utils()
        val result = sut.reverseString3(null)
//        assertEquals("edoCyzeehC", result)// this line not required because this test case will throw Exception
    }
}