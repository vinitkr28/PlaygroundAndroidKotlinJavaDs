package cheezy_code

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import cheezy_code.unit_testing.Quote
import cheezy_code.unit_testing.QuoteDatabase
import cheezy_code.unit_testing.QuotesDao
import cheezy_code.unit_testing.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuoteDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var quoteDatabase: QuoteDatabase
    lateinit var quotesDao: QuotesDao

    @Before
    fun setUp() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()

        quotesDao = quoteDatabase.quoteDao()
    }

    @After
    fun tearDown() {
        quoteDatabase.close()
    }



    @Test
    fun insertQuote_expectedSingleQuote() = runBlocking{
        val quote = Quote(1, "", "", "", "", 0, "Book Name")
        quotesDao.insertQuote(quote)

        val result = quotesDao.getQuotes().getOrAwaitValue()

        assertEquals(1, result.size)
        assertEquals("Book Name", result[0].book_name)

    }
}