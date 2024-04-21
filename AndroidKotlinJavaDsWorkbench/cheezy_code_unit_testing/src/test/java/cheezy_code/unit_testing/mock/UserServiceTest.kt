package cheezy_code.unit_testing.mock

import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
//        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testUserService() {
        Mockito.`when`(userRepository.loginUser(anyString(), anyString()))
            .thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
        val sut = UserService(userRepository)
        val status = sut.loginUser("abc@gmail.com", "1111111")
        assertEquals("Password is invalid", status)
    }

    @Test
    fun testUserService_loginSuccess() {
        Mockito.`when`(userRepository.loginUser(anyString(), anyString()))
            .thenReturn(LOGIN_STATUS.SUCCESS)
        val sut = UserService(userRepository)
        val status = sut.loginUser("abc@gmail.com", "1111111")
        assertEquals("Logged in successfully", status)
    }
}