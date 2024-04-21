package cheezy_code.unit_testing.utils

import android.content.Context
import android.content.res.AssetManager
import cheezy_code.unit_testing.QuoteManager
import com.nhaarman.mockitokotlin2.doReturn
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class QuoteManagerTest {
    @Mock
    lateinit var context: Context

    @Mock
    lateinit var assertManager: AssetManager
    @Before
    fun  setUp(){
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown(){

    }

    @Test
    fun test(){
        val testStream = QuoteManagerTest::class.java.getResourceAsStream("/quotes.json")
        doReturn(assertManager).`when`(context).assets
        Mockito.`when`(context.assets.open(anyString())).thenReturn(testStream)


        val sut = QuoteManager()
        sut.populateQuoteFromAssets(context, "")
        val quote = sut.getCurrentQuote()
        Assert.assertEquals("A Christmas carol", quote.book_name)
    }


}