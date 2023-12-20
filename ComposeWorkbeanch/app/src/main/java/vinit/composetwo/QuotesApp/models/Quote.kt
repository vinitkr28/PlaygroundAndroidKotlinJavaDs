package vinit.composetwo.QuotesApp.models

data class Quote(
    val amazon_link: String,
    val author: String,
    val availability: String,
    val genre: String,
    val reeading_time_in_hr_approx: Int,
    val book_name: String
)