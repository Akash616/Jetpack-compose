package com.ui.quotecomposeapp.screens

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.ui.quotecomposeapp.models.Quote

@Composable
fun QuoteList(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {

    //List render - like recyclerview
    LazyColumn(content = {
        items(data){
            QuoteListItem(quote = it, onClick)
        }
    })

}