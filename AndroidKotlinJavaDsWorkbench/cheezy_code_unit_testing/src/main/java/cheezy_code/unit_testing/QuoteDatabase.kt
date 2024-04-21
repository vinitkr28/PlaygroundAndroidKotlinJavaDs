package cheezy_code.unit_testing

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun quoteDao(): QuotesDao
}