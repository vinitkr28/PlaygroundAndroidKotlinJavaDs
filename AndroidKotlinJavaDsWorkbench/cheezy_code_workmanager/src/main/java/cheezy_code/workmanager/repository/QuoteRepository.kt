package cheezy_code.workmanager.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cheezy_code.workmanager.api.QuoteService
import cheezy_code.workmanager.db.QuoteDatabase
import cheezy_code.workmanager.models.QuoteList
import cheezy_code.workmanager.utils.NetworkUtils

private const val TAG = "QuoteRepository"
class QuoteRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quotesLiveData

    suspend fun getQuotes(page: Int){

        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = quoteService.getQuotes(page)
            if(result.body() != null){
                Log.d(TAG, "getQuotes: ${result.body()!!.results}")
                quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
                quotesLiveData.postValue(result.body())
            }
        } else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1,1,1,quotes, 1, 1)
            quotesLiveData.postValue(quoteList)
        }

    }

    suspend fun getQuotesBackground(){
        val randomNumber = (Math.random() * 10).toInt()
        val result = quoteService.getQuotes(randomNumber)
        if (result.body() != null) {
            Log.d(TAG, "getQuotesBackground: ${result.body()!!.results}")
            quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
        }
    }
}






