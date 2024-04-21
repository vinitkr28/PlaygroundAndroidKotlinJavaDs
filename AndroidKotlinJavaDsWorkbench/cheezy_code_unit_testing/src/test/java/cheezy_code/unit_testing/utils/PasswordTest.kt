package cheezy_code.unit_testing.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordTest {

    @Test
    fun validatePassword2_blankInput_expectedRequiredField() {
        //systemUnderTest
        val sut = Utils()
        val result = sut.validatePassword2("     ")
        assertEquals("Password is required field", result)
    }

    @Test
    fun validatePassword2_2CharInput_expectedValidationMsg() {
        //systemUnderTest
        val sut = Utils()
        val result = sut.validatePassword2("ab")
        assertEquals("Length of the password should be greater tna 6", result)
    }

    @Test
    fun validatePassword2_CorrectInput_expectedValidPassword() {
        //systemUnderTest
        val sut = Utils()
        val result = sut.validatePassword2("Pass123")
        assertEquals("Valid", result)
    }
}