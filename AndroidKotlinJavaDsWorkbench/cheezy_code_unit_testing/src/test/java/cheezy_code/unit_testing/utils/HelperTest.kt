package cheezy_code.unit_testing.utils

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HelperTest {

    @Before
    fun setUp() {
    }

    @Test
    fun isPalindrome_inputString_hello_expectedFalse() {
        //Arrange
        //Act
        //Assert


        //Arrange
        val helper = Helper()

        //Act
        val result = helper.isPalindrome("hello")

        //Assert
        assertEquals(false, result)


    }


    @Test
    fun isPalindrome_inputString_level_expectedTrue() {
        //Arrange
        //Act
        //Assert


        //Arrange
        val helper = Helper()

        //Act
        val result = helper.isPalindrome("level")

        //Assert
        assertEquals(true, result)


    }

    @Test
    fun isPalindrome_inputString_empty_expectedTrue() {
        val helper = Helper()
        val result = helper.isPalindrome("")
        assertEquals(true, result)
    }

    @Test
    fun isPalindrome_inputString_a_expectedTrue() {
        val helper = Helper()
        val result = helper.isPalindrome("a")
        assertEquals(true, result)
    }
}