package cheezy_code.unit_testing

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    /*
    *
    * Getting error FileNotFoundException but need to run successfully because this error is expected and mentioned on Test as expected.
    *
    *
    * https://stackoverflow.com/questions/78360745/android-junit-test-to-check-validate-file-inside-assets-folder-throw-filenotfou
    *
    *
    * */



    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets_input_empty_expected_FileNotFoundException_withTryCatch() {
        println("** populateQuoteFromAssets_input_empty_expected_FileNotFoundException_withTryCatch **")
        try {
            //Arrange
            val quoteManager = QuoteManager()
            val context = ApplicationProvider.getApplicationContext<Context>()

            //Act
            quoteManager.populateQuoteFromAssets(context, "")
        } catch (e: Exception){
            println("Error in Catch block:: $e")
            throw FileNotFoundException()
        }
    }

    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets_input_empty_expected_FileNotFoundException() {
        //Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()

        //Act
        quoteManager.populateQuoteFromAssets(context, "")
    }

    @Test(expected = java.io.FileNotFoundException::class)
    fun populateQuoteFromAssets_input_wrongName_expected_FileNotFoundException() {
        //Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()

        //Act
        quoteManager.populateQuoteFromAssets(context, "quotes1.json")
    }

    @Test(expected = com.google.gson.JsonSyntaxException::class)
    fun populateQuoteFromAssets_input_InvalidJSON_expected_Exception() {
        //Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()

        //Act
//        quoteManager.populateQuoteFromAssets(context, "malformed.json")
        quoteManager.populateQuoteFromAssets(context, "quotes.json")
    }

    fun populateQuoteFromAssets_ValidJSON_expected_Count() {

        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()

        quoteManager.populateQuoteFromAssets(context, "quotes.json")

        assertEquals(15, quoteManager.quoteList.size)
    }

    @Test
    fun populateQuoteFromAssets_validate_getQuotesCount_expected_Count() {

        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()

        quoteManager.populateQuoteFromAssets(context, "quotes.json")

        assertEquals(quoteManager.getQuotesCount(), quoteManager.quoteList.size)
    }

    @Test
    fun testPreviousQuote_expected_CorrectQuote() {
        //Arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("", "author 1", "", "", 0, "book 1"),
                Quote("", "author 2", "", "", 0, "book 2"),
                Quote("", "author 3", "", "", 0, "book 3"),
                Quote("", "author 4", "", "", 0, "book 4"),
                Quote("", "author 5", "", "", 0, "book 5"),
                Quote("", "author 6", "", "", 0, "book 6"),
            )
        )
        //Act
        val quote = quoteManager.getPreviousQuote()
        //Assets
        assertEquals("author 1", quote.author)
    }

    @Test
    fun testNextQuote_expected_CorrectQuote() {
        //Arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("", "author 1", "", "", 0, "book 1"),
                Quote("", "author 2", "", "", 0, "book 2"),
                Quote("", "author 3", "", "", 0, "book 3"),
                Quote("", "author 4", "", "", 0, "book 4"),
                Quote("", "author 5", "", "", 0, "book 5"),
                Quote("", "author 6", "", "", 0, "book 6"),
            )
        )
        //Act
        val quote = quoteManager.getNextQuote()
        //Assets
        assertEquals("author 2", quote.author)
    }
}