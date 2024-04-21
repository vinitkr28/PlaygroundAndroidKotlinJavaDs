package cheezy_code.unit_testing

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuotesDao {

    @Insert
    fun insertQuote(quote: Quote)

    @Update
    fun updateQuote(quote: Quote)

//    @Query("DELETE FROM quote")
//    suspend fun delete()

    @Query("SELECT * FROM quote")
    fun getQuotes() : LiveData<List<Quote>>

    @Query("SELECT * FROM quote where id = :quoteId")
    fun getQuoteById(quoteId: Int) : Quote
}