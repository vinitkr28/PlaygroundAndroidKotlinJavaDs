package vinit.composetwo.QuotesApp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import vinit.composetwo.QuotesApp.models.Quote

@Composable
fun QuoteList(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    LazyColumn(content = {
        items(data.size){
            QuoteListItem(quote = data[it], onClick)
        }
    })
}