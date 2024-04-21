package cheezy_code.unit_testing

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.io.FileNotFoundException
import java.io.InputStream

private const val TAG = "QuoteManager"
class QuoteManager {

    var quoteList = emptyArray<Quote>()
    var currentQuoteIndex = 0

    fun populateQuoteFromAssets(context: Context, fileName: String) {
        var inputStream: InputStream? = null
        try {
            inputStream = context.assets.open("quotes.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, Charsets.UTF_8)
            val gson = Gson()
            quoteList = gson.fromJson(json, Array<Quote>::class.java)
        } /*catch (e: FileNotFoundException) {
            throw e;
        } catch (e: JsonSyntaxException){
            Log.d(TAG, "populateQuoteFromAssets: $e")
            Log.d(TAG, "populateQuoteFromAssets: ***********************")
            throw e;
        }*/
        catch (e: Exception) {
            throw  e
        }
        finally {
            inputStream?.close()
        }

    }

    fun populateQuotes(quotes: Array<Quote>) {
        quoteList = quotes
    }

    fun getCurrentQuote(): Quote {
        return quoteList[currentQuoteIndex]
    }

    fun getNextQuote(): Quote {
        if (currentQuoteIndex == quoteList.size - 1) return quoteList.last()
        return quoteList[++currentQuoteIndex]
    }

    fun getPreviousQuote(): Quote {
        if (currentQuoteIndex == 0) return quoteList.first()
        return quoteList[--currentQuoteIndex]
    }

    fun getQuotesCount(): Int {
        return quoteList.size
    }
}