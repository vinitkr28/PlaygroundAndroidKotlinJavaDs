package cheezy_code.jetpack_compose.quotes_app.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import cheezy_code.jetpack_compose.quotes_app.models.Quote

@Composable
fun QuoteList(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    LazyColumn(content = {
        items(data.size){
            QuoteListItem(quote = data[it], onClick)
        }
    })
}