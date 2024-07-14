package com.ui.quotecomposeapp

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.ui.quotecomposeapp.models.Quote

object DataManager {

    var data = emptyArray<Quote>()
    var currentQuote: Quote? = null

    var isDataLoaded = mutableStateOf(false) //thread safe - means access from any thread.
    var currentPage = mutableStateOf(Pages.LISTING)

    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")

        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8) //convert into string

        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        // Add logging to verify parsing
        data.forEach {
            Log.d("DataManager", "Loaded Quote: ${it.quote}, Author: ${it.author}")
        }
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?){
        if (currentPage.value == Pages.LISTING){
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }

}