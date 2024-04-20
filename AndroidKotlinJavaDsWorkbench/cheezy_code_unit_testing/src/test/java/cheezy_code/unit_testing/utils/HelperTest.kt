package cheezy_code.unit_testing.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    lateinit var helper: Helper

    @Before
    fun setUp() {
//        println("Before Every Test Case.")
        helper = Helper()

    }

    @After
    fun tearDown() {
        println("After Every Test Cases")
    }


    //START ************* ## $$ ** isPallindromeLogic1 ** $$ ## *************

    @Test
    fun isPallindromeLogic1_inpitString_hello_expectedFalse() {
        //Arrange
//        val helper = Helper()

        //Act
        val result = helper.isPallindromeLogic1("hello")

        //Assert
        assertEquals(false, result)
    }


    @Test
    fun isPallindromeLogic1_inpitString_level_expectedTrue() {
        //Arrange
//        val helper = Helper()

        //Act
        val result = helper.isPallindromeLogic1("level")

        //Assert
        assertEquals(true, result)
    }

    @Test
    fun isPallindromeLogic1_inpit_EmptyString_expectedTrue() {
        //Arrange
//        val helper = Helper()

        //Act
        val result = helper.isPallindromeLogic1("")

        //Assert
        assertEquals(true, result)
    }

    @Test
    fun isPallindromeLogic1_inpit_SingleCharactor_expectedTrue() {
        //Arrange
//        val helper = Helper()

        //Act
        val result = helper.isPallindromeLogic1("a")

        //Assert
        assertEquals(true, result)
    }

    //END ************* ## $$ ** isPallindromeLogic1 ** $$ ## *************

    //START ************* ## $$ ** isPallindromeLogic2 ** $$ ## *************
    @Test
    fun isPallindromeLogic2_inpitString_hello_expectedFalse() {
        //Arrange
//        val helper = Helper()

        //Act
        val result = helper.isPallindromeLogic2("hello")

        //Assert
        assertEquals(false, result)
    }


    @Test
    fun isPallindromeLogic2_inpitString_level_expectedTrue() {
        //Arrange
//        val helper = Helper()

        //Act
        val result = helper.isPallindromeLogic2("level")

        //Assert
        assertEquals(true, result)
    }

    @Test
    fun isPallindromeLogic2_inpit_EmptyString_expectedTrue() {
        //Arrange
//        val helper = Helper()

        //Act
        val result = helper.isPallindromeLogic2("")

        //Assert
        assertEquals(true, result)
    }

    @Test
    fun isPallindromeLogic2_inpit_SingleCharactor_expectedTrue() {
        //Arrange
//        val helper = Helper()

        //Act
        val result = helper.isPallindromeLogic2("a")

        //Assert
        assertEquals(true, result)
    }

    //END ************* ## $$ ** isPallindromeLogic2 ** $$ ## *************
}