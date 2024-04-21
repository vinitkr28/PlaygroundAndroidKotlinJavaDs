package cheezy_code.unit_testing

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val amazon_link: String,
    val author: String,
    val availability: String,
    val genre: String,
    val reeading_time_in_hr_approx: Int,
    val book_name: String
)
